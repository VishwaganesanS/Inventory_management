package com.inventory.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotBlank(message = "Category name is required")
    @Size(min = 3, max = 50)
    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column(length = 200)
    private String Description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
