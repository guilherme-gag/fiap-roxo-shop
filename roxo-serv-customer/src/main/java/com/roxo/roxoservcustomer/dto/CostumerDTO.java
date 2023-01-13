package com.roxo.roxoservcustomer.dto;

import com.roxo.roxoservcustomer.entity.CostumerEntity;

public class CostumerDTO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CostumerDTO() {
    }

    public CostumerDTO(CostumerEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
