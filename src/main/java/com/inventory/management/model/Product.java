package com.inventory.management.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 100)
    @Column(nullable = false)
    private String productName;

    @NotBlank(message = "SKU code is required")
    @Column(nullable = false, unique = true)
    private String skuCode;

    @Column(unique = true)
    private String serialNumber;

    @NotBlank(message = "Brand is required")
    @Column(nullable = false)
    private String brand;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive value")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Selling price is required")
    @Positive(message = "Selling price must be a positive value")
    @Column(nullable = false)
    private Double sellingPrice;

    @NotNull(message = "Quantity stock is required")
    @Min(value = 0, message = "Quantity stock cannot be negative")
    @Column(nullable = false)
    private Integer quantityStock;

    @NotNull(message = "Manufactured date is required")
    @Column(nullable = false)
    private LocalDate manufacturedDate;

    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<SaleItem> saleItems;

    @OneToMany(mappedBy = "product")
    private List<PurchaseItem> purchaseItems;
}