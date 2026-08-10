package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.SaleItem;
import com.inventory.management.repository.SaleItemRepository;

import java.time.LocalDateTime;

import com.inventory.management.model.InventoryTransaction;
import com.inventory.management.model.Product;
import com.inventory.management.repository.InventoryTransactionRepository;
import com.inventory.management.repository.ProductRepository;

@Service
public class SaleItemService {
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public SaleItem addSaleItem(SaleItem saleItem) {

        SaleItem savedSaleItem = saleItemRepository.save(saleItem);

        System.out.println("SaleItem Saved");

        Product product = productRepository
                .findById(savedSaleItem.getProduct().getProductId())
                .orElse(null);

        System.out.println("Product = " + product);

        if (product != null) {

            System.out.println("Current Stock = " + product.getQuantityStock());
            System.out.println("Sold Quantity = " + savedSaleItem.getQuantity());

            if (product.getQuantityStock() < savedSaleItem.getQuantity()) {
                throw new RuntimeException("Not enough stock available");
            }

            product.setQuantityStock(
                    product.getQuantityStock() - savedSaleItem.getQuantity());

            System.out.println("New Stock = " + product.getQuantityStock());

            productRepository.save(product);

            InventoryTransaction transaction = new InventoryTransaction();

            transaction.setTransactionType("SALE");
            transaction.setQuantity(savedSaleItem.getQuantity());
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setProduct(product);

            inventoryTransactionRepository.save(transaction);
        }

        return savedSaleItem;
    }

    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    public SaleItem getSaleItemById(Integer id) {
        return saleItemRepository.findById(id).orElse(null);
    }

    public void deleteSaleItem(Integer id) {
        saleItemRepository.deleteById(id);
    }
}
