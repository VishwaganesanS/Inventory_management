package com.inventory.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @NotBlank(message = "Supplier name is required")
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String supplierName;

    @NotBlank(message = "Contact person should not be blank")
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String contactPerson;

    @NotBlank(message = "Company name should not be blank")
    @Size(min = 3, max = 100)
    @Column(nullable = false)
    private String companyName;

    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
    @Column(length = 10)
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchases;
}
