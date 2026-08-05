package com.inventory.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
