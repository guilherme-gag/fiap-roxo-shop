package com.roxo.roxoservorder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roxo.roxoservproduct.dto.ProductCreateUpdateDTO;
import com.roxo.roxoservproduct.dto.ProductDTO;
import com.roxo.roxoservproduct.entity.ProductEntity;
import com.roxo.roxoservproduct.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements OrderService {

    private ProductRepository repository;
    private ObjectMapper objectMapper;

    public ProductServiceImpl(ProductRepository repository,
                           ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    @Override
    public ProductDTO create(ProductCreateUpdateDTO createUpdateDTO) {
        ProductEntity entity = new ProductEntity(createUpdateDTO);
        ProductEntity savedEntity = repository.save(entity);
        return new ProductDTO(savedEntity);
    }

    @Override
    public ProductDTO findById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        ProductDTO dto = objectMapper.convertValue(entity, ProductDTO.class);
        return dto;
    }

    @Override
    public List<ProductDTO> listAll() {
        List<ProductEntity> list = repository.findAll();
        return list.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public ProductDTO update(Long id, ProductCreateUpdateDTO createUpdateDTO) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setName(createUpdateDTO.getName());
        entity.setPrice(createUpdateDTO.getPrice());
        ProductEntity savedEntity = repository.save(entity);
        return new ProductDTO(savedEntity);
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
