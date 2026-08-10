package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Product;
import com.inventory.management.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Product updateProductName(Integer id, String productName) {
        Product product = productRepository.findById(id).orElse(null);

        System.out.println("Product = " + product);
        System.out.println("New Name = " + productName);

        if (product != null) {

            product.setProductName(productName);
            return productRepository.save(product);
        }

        return null;
    }
}
