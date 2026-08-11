package com.inventory.management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PurchaseItemRequestDTO {
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be atleast 1")
    private Integer quantity;

    @NotNull(message = "Purchase Price is required")
    @Min(value = 1, message = "Purchase price must be greater than 0")
    private Double purchasePrice;

    @NotNull(message = "Purchase ID is required")
    private Integer purchaseId;

    @NotNull(message = "Product ID is required")
    private Integer productId;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
