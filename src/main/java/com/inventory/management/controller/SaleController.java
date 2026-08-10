package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.model.Sale;
import com.inventory.management.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return "Sale deleted successfully";
    }
}