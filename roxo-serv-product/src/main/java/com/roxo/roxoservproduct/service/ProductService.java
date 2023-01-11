package com.roxo.roxoservproduct.service;

import com.roxo.roxoservproduct.dto.ProductCreateUpdateDTO;
import com.roxo.roxoservproduct.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductCreateUpdateDTO createUpdateDTO);
    ProductDTO findById(Long id);
    List<ProductDTO> listAll();
    ProductDTO update(Long id, ProductCreateUpdateDTO createUpdateDTO);
    void delete(Long id);
}
