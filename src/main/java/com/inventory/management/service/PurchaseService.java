package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Purchase;
import com.inventory.management.model.PurchaseItem;
import com.inventory.management.repository.PurchaseRepository;
import com.inventory.management.repository.PurchaseItemRepository;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

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

    public Purchase recalculatePurchaseTotal(Integer purchaseId) {

        Purchase purchase = purchaseRepository
                .findById(purchaseId)
                .orElse(null);

        if (purchase == null) {
            return null;
        }

        List<PurchaseItem> purchaseItems = purchaseItemRepository.findByPurchase_PurchaseId(purchaseId);

        double total = 0;

        for (PurchaseItem item : purchaseItems) {
            total += item.getQuantity() * item.getPurchasePrice();
        }

        purchase.setTotalAmount(total);

        return purchaseRepository.save(purchase);
    }
}