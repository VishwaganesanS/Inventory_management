package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.dto.PurchaseItemRequestDTO;
import com.inventory.management.model.Product;
import com.inventory.management.model.Purchase;
import com.inventory.management.model.PurchaseItem;
import com.inventory.management.service.PurchaseItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/purchase_items")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService purchaseItemService;

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

    @GetMapping
    public List<PurchaseItem> getAllPurchaseItems() {
        return purchaseItemService.getAllPurchaseItems();
    }

    @GetMapping("/{id}")
    public PurchaseItem getPurchaseItemById(@PathVariable Integer id) {
        return purchaseItemService.getPurchaseItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePurchaseItem(@PathVariable Integer id) {
        purchaseItemService.deletePurchaseItem(id);
        return "Purchase item deleted successfully";
    }
}