package com.inventory.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.model.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Integer> {

}
