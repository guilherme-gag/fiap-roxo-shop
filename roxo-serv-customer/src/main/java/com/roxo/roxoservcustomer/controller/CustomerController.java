package com.roxo.roxoservcustomer.controller;

import com.roxo.roxoservcustomer.dto.CostumerCreateUpdateDTO;
import com.roxo.roxoservcustomer.dto.CostumerDTO;
import com.roxo.roxoservcustomer.service.CostumerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private  final CostumerService service;

    public CustomerController(CostumerService service){this.service = service;};

    @GetMapping
    public List<CostumerDTO> list() {
        return service.listAll();
    }

    @GetMapping("{id}")
    public CostumerDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CostumerDTO create(@RequestBody CostumerCreateUpdateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public CostumerDTO update(@PathVariable Long id,
                             @RequestBody CostumerCreateUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
