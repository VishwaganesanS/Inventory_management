package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.dto.PurchaseItemRequestDTO;
import com.inventory.management.model.Product;
import com.inventory.management.model.Purchase;
import com.inventory.management.model.PurchaseItem;
import com.inventory.management.service.PurchaseItemService;
import com.inventory.management.service.PurchaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseItemService purchaseItemService;

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

    @PostMapping
    public PurchaseItem addPurchaseItem(
            @Valid @RequestBody PurchaseItemRequestDTO dto) {

        PurchaseItem purchaseItem = new PurchaseItem();

        purchaseItem.setQuantity(dto.getQuantity());
        purchaseItem.setPurchasePrice(dto.getPurchasePrice());

        Purchase purchase = new Purchase();
        purchase.setPurchaseId(dto.getPurchaseId());
        purchaseItem.setPurchase(purchase);

        Product product = new Product();
        product.setProductId(dto.getProductId());
        purchaseItem.setProduct(product);

        return purchaseItemService.addPurchaseItem(purchaseItem);
    }
}