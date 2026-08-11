package com.inventory.management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItemRequestDTO {

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private Integer quantity;

    @NotNull(message = "Selling price is required")
    @Positive(message = "Selling price must be greater than 0")
    private Double sellingPrice;

    @NotNull(message = "Sale ID is required")
    private Integer saleId;

    @NotNull(message = "Product ID is required")
    private Integer productId;
}