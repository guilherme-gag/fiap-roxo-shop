package com.roxo.roxoservcustomer.service;


import com.roxo.roxoservcustomer.dto.CostumerCreateUpdateDTO;
import com.roxo.roxoservcustomer.dto.CostumerDTO;

import java.util.List;

public interface CostumerService {
    CostumerDTO create(CostumerCreateUpdateDTO createUpdateDTO);
    CostumerDTO findById(Long id);
    List<CostumerDTO> listAll();
    CostumerDTO update(Long id, CostumerCreateUpdateDTO createUpdateDTO);
    void delete(Long id);
}
