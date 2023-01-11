package com.roxo.roxoservproduct.repository;

import com.roxo.roxoservproduct.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByProductId(long productId);
}
