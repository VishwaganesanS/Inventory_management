package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.dto.SaleItemRequestDTO;
import com.inventory.management.model.Product;
import com.inventory.management.model.Sale;
import com.inventory.management.model.SaleItem;
import com.inventory.management.service.SaleItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sale_items")
public class SaleItemController {

    @Autowired
    private SaleItemService saleItemService;

    @PostMapping
    public SaleItem addSaleItem(
            @Valid @RequestBody SaleItemRequestDTO dto) {

        SaleItem saleItem = new SaleItem();

        saleItem.setQuantity(dto.getQuantity());
        saleItem.setSellingPrice(dto.getSellingPrice());

        Sale sale = new Sale();
        sale.setSaleId(dto.getSaleId());
        saleItem.setSale(sale);

        Product product = new Product();
        product.setProductId(dto.getProductId());
        saleItem.setProduct(product);

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