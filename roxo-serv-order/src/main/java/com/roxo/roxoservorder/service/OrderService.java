package com.roxo.roxoservorder.service;

import com.roxo.roxoservorder.dto.OrderCreateDTO;
import com.roxo.roxoservorder.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO create(OrderCreateDTO createUpdateDTO);
    List<OrderDTO> listAll();
    OrderDTO findById(Long id);
    OrderDTO update(Long id, OrderCreateDTO createUpdateDTO);
    void delete(Long id);

}
