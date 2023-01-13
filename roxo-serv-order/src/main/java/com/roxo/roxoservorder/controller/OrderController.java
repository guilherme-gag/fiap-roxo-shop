package com.roxo.roxoservorder.controller;

import com.roxo.roxoservorder.dto.OrderCreateDTO;
import com.roxo.roxoservorder.dto.OrderDTO;
import com.roxo.roxoservorder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderDTO> list() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO create(@RequestBody OrderCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("{id}")
    public OrderDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderCreateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
