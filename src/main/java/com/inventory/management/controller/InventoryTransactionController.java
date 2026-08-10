package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.model.InventoryTransaction;
import com.inventory.management.service.InventoryTransactionService;

@RestController
@RequestMapping("/inventorytransactions")
public class InventoryTransactionController {
    @Autowired
    private InventoryTransactionService inventoryTransactionService;

    @PostMapping
    public InventoryTransaction addInventoryTransaction(@RequestBody InventoryTransaction inventoryTransaction) {
        return inventoryTransactionService.addInventoryTransaction(inventoryTransaction);
    }

    @GetMapping
    public List<InventoryTransaction> getAllInventoryTransactions() {
        return inventoryTransactionService.getAllInventoryTransactions();
    }

    @GetMapping("/{id}")
    public InventoryTransaction getInventoryTransactionById(@PathVariable Integer id) {
        return inventoryTransactionService.getInventoryTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteInventoryTransaction(@PathVariable Integer id) {
        inventoryTransactionService.deleteInventoryTransaction(id);
        return "Inventory transaction deleted successfully";
    }
}
