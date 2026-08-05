package com.inventory.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
