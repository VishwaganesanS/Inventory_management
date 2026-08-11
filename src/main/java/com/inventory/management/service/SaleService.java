package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Sale;
import com.inventory.management.model.SaleItem;
import com.inventory.management.repository.SaleItemRepository;
import com.inventory.management.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

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

    // Recalculate total amount of an existing sale
    public Sale recalculateSaleTotal(Integer saleId) {

        Sale sale = saleRepository
                .findById(saleId)
                .orElse(null);

        if (sale == null) {
            return null;
        }

        List<SaleItem> saleItems = saleItemRepository.findBySale_SaleId(saleId);

        double total = 0;

        for (SaleItem item : saleItems) {
            total += item.getQuantity() * item.getSellingPrice();
        }

        sale.setTotalAmount(total);

        return saleRepository.save(sale);
    }

    public Sale updateSale(Integer id, Sale updatedSale) {

        Sale existingSale = saleRepository.findById(id).orElse(null);

        if (existingSale == null) {
            return null;
        }

        existingSale.setSaleDate(updatedSale.getSaleDate());
        existingSale.setCustomer(updatedSale.getCustomer());
        existingSale.setEmployee(updatedSale.getEmployee());

        return saleRepository.save(existingSale);
    }
}