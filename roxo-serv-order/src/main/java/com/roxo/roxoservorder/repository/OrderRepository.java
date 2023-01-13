package com.roxo.roxoservorder.repository;

import com.roxo.roxoservorder.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

}
