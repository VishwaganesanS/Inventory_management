package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.InventoryTransaction;
import com.inventory.management.repository.InventoryTransactionRepository;

@Service
public class InventoryTransactionService {
    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public InventoryTransaction addInventoryTransaction(InventoryTransaction inventoryTransaction) {
        return inventoryTransactionRepository.save(inventoryTransaction);
    }

    public List<InventoryTransaction> getAllInventoryTransactions() {
        return inventoryTransactionRepository.findAll();
    }

    public InventoryTransaction getInventoryTransactionById(Integer id) {
        return inventoryTransactionRepository.findById(id).orElse(null);
    }

    public void deleteInventoryTransaction(Integer id) {
        inventoryTransactionRepository.deleteById(id);
    }
}
