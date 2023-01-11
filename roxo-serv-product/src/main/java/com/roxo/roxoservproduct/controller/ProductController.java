package com.roxo.roxoservproduct.controller;

import com.roxo.roxoservproduct.dto.ProductCreateUpdateDTO;
import com.roxo.roxoservproduct.dto.ProductDTO;
import com.roxo.roxoservproduct.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private  final ProductService service;

    public ProductController(ProductService service){this.service = service;};

    @GetMapping
    public List<ProductDTO> list() {
        return service.listAll();
    }

    @GetMapping("{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateUpdateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ProductDTO update(@PathVariable Long id,
                             @RequestBody ProductCreateUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
