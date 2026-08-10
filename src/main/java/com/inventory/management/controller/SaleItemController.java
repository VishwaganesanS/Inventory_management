package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.model.SaleItem;
import com.inventory.management.service.SaleItemService;

@RestController
@RequestMapping("/sale_items")
public class SaleItemController {
    @Autowired
    private SaleItemService saleItemService;

    @PostMapping
    public SaleItem addSaleItem(@RequestBody SaleItem saleItem) {
        return saleItemService.addSaleItem(saleItem);
    }

    @GetMapping
    public List<SaleItem> getAllSaleItems() {
        return saleItemService.getAllSaleItems();
    }

    @GetMapping("/{id}")
    public SaleItem getSaleItemById(@PathVariable Integer id) {
        return saleItemService.getSaleItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSaleItem(@PathVariable Integer id) {
        saleItemService.deleteSaleItem(id);
        return "Sale item deleted successfully";
    }
}
