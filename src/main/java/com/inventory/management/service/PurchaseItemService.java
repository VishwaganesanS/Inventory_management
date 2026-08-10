package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.PurchaseItem;
import com.inventory.management.repository.PurchaseItemRepository;

import java.time.LocalDateTime;

import com.inventory.management.model.InventoryTransaction;
import com.inventory.management.model.Product;
import com.inventory.management.repository.InventoryTransactionRepository;
import com.inventory.management.repository.ProductRepository;

@Service
public class PurchaseItemService {

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public PurchaseItem addPurchaseItem(PurchaseItem purchaseItem) {

        PurchaseItem savedPurchaseItem = purchaseItemRepository.save(purchaseItem);

        Product product = productRepository
                .findById(savedPurchaseItem.getProduct().getProductId())
                .orElse(null);

        if (product != null) {

            product.setQuantityStock(
                    product.getQuantityStock() + savedPurchaseItem.getQuantity());

            productRepository.save(product);

            InventoryTransaction transaction = new InventoryTransaction();

            transaction.setTransactionType("PURCHASE");
            transaction.setQuantity(savedPurchaseItem.getQuantity());
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setProduct(product);

            inventoryTransactionRepository.save(transaction);
        }

        return savedPurchaseItem;
    }

    public List<PurchaseItem> getAllPurchaseItems() {
        return purchaseItemRepository.findAll();
    }

    public PurchaseItem getPurchaseItemById(Integer id) {
        return purchaseItemRepository.findById(id).orElse(null);
    }

    public void deletePurchaseItem(Integer id) {
        purchaseItemRepository.deleteById(id);
    }
}
