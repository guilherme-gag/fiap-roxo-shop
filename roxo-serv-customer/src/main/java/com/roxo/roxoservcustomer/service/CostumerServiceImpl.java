package com.roxo.roxoservcustomer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roxo.roxoservcustomer.dto.CostumerCreateUpdateDTO;
import com.roxo.roxoservcustomer.dto.CostumerDTO;
import com.roxo.roxoservcustomer.entity.CostumerEntity;
import com.roxo.roxoservcustomer.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerServiceImpl implements CostumerService {

    private ProductRepository repository;
    private ObjectMapper objectMapper;

    public CostumerServiceImpl(ProductRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    @Override
    public CostumerDTO create(CostumerCreateUpdateDTO createUpdateDTO) {
        CostumerEntity entity = new CostumerEntity(createUpdateDTO);
        CostumerEntity savedEntity = repository.save(entity);
        return new CostumerDTO(savedEntity);
    }

    @Override
    public CostumerDTO findById(Long id) {
        CostumerEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        CostumerDTO dto = objectMapper.convertValue(entity, CostumerDTO.class);
        return dto;
    }

    @Override
    public List<CostumerDTO> listAll() {
        List<CostumerEntity> list = repository.findAll();
        return list.stream()
                .map(CostumerDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public CostumerDTO update(Long id, CostumerCreateUpdateDTO createUpdateDTO) {
        CostumerEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setName(createUpdateDTO.getName());
        CostumerEntity savedEntity = repository.save(entity);
        return new CostumerDTO(savedEntity);
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
