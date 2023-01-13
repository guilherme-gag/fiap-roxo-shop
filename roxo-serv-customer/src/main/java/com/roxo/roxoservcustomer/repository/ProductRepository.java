package com.roxo.roxoservcustomer.repository;

import com.roxo.roxoservcustomer.entity.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<CostumerEntity,Long> {

}
