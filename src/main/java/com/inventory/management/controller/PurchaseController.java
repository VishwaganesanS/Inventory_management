package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.model.Purchase;
import com.inventory.management.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        return purchaseService.addPurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable Integer id) {
        return purchaseService.getPurchaseById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable Integer id) {
        purchaseService.deletePurchase(id);
        return "Purchase deleted successfully";
    }

    @PutMapping("/{id}/recalculate")
    public Purchase recalculatePurchaseTotal(@PathVariable Integer id) {
        return purchaseService.recalculatePurchaseTotal(id);
    }
}