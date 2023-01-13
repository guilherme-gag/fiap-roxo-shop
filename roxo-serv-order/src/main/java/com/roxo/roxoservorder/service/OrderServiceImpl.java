package com.roxo.roxoservorder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roxo.roxoservorder.dto.OrderCreateDTO;
import com.roxo.roxoservorder.dto.OrderDTO;
import com.roxo.roxoservorder.entity.OrderEntity;
import com.roxo.roxoservorder.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private ObjectMapper objectMapper;

    public OrderServiceImpl(OrderRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<OrderDTO> listAll() {
        List<OrderEntity> list = repository.findAll();
        return list.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO create(OrderCreateDTO createUpdateDTO) {
        OrderEntity entity = new OrderEntity(createUpdateDTO);
        OrderEntity savedEntity = repository.save(entity);
        return new OrderDTO(savedEntity);
    }

    @Override
    public OrderDTO findById(Long id) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        OrderDTO dto = objectMapper.convertValue(entity, OrderDTO.class);
        return dto;
    }

    @Override
    public OrderDTO update(Long id, OrderCreateDTO createUpdateDTO) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setCustomerId(createUpdateDTO.getCustomerId());
        entity.setCustomerName(createUpdateDTO.getCustomerName());
        entity.setProductId(createUpdateDTO.getProductId());
        entity.setProductName(createUpdateDTO.getProductName());
        entity.setProductPrice(createUpdateDTO.getProductPrice());
        entity.setQuantity(createUpdateDTO.getQuantity());
        OrderEntity savedEntity = repository.save(entity);
        return new OrderDTO(savedEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
