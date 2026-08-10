package com.inventory.management.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    private LocalDate purchaseDate;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @JsonIgnore
    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItem> purchaseItems;
}