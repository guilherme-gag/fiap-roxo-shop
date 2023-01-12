package com.roxo.roxoservcustomer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @GetMapping
    public ResponseEntity<List<Long>> getCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }
}
