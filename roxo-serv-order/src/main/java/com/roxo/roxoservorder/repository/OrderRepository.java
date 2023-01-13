package com.roxo.roxoservorder.repository;

import com.roxo.roxoservproduct.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEn,Long> {

}
