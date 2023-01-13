package com.roxo.roxoservorder.entity;

import com.roxo.roxoservproduct.dto.ProductCreateUpdateDTO;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_ORDER")
@EntityListeners(AuditingEntityListener.class)
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderProductEntity() {
    }

    public OrderProductEntity(ProductCreateUpdateDTO dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
    }
}
