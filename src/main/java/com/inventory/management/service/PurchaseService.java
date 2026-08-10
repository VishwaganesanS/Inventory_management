package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Purchase;
import com.inventory.management.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Integer id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public void deletePurchase(Integer id) {
        purchaseRepository.deleteById(id);
    }
}
