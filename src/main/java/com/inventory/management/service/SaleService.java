package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Sale;
import com.inventory.management.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Integer id) {
        return saleRepository.findById(id).orElse(null);
    }

    public void deleteSale(Integer id) {
        saleRepository.deleteById(id);
    }
}
