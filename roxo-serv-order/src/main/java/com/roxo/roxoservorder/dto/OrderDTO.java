package com.roxo.roxoservorder.dto;

import com.roxo.roxoservorder.entity.OrderEntity;

public class OrderDTO {

    private Long id;
    private Long customerId;
    private String customerName;
    private Long productId;
    private String productName;
    private Double productPrice;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public OrderDTO() {
    }

    public OrderDTO(OrderEntity entity) {
        this.id = entity.getId();
        this.customerId = entity.getCustomerId();
        this.customerName = entity.getCustomerName();
        this.productId = entity.getProductId();
        this.productName = entity.getProductName();
        this.productPrice = entity.getProductPrice();
        this.quantity = entity.getQuantity();
    }

}
