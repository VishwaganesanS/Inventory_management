package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.model.PurchaseItem;
import com.inventory.management.service.PurchaseItemService;

@RestController
@RequestMapping("/purchaseitems")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService purchaseItemService;

    @PostMapping
    public PurchaseItem addPurchaseItem(@RequestBody PurchaseItem purchaseItem) {
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
