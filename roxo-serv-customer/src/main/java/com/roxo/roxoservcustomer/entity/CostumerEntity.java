package com.roxo.roxoservcustomer.entity;

import com.roxo.roxoservcustomer.dto.CostumerCreateUpdateDTO;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_COSTUMER")
@EntityListeners(AuditingEntityListener.class)
public class CostumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CostumerEntity() {
    }

    public CostumerEntity(CostumerCreateUpdateDTO dto) {
        this.name = dto.getName();
    }
}
