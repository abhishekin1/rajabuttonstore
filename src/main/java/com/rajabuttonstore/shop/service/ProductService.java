package com.rajabuttonstore.shop.service;

import com.rajabuttonstore.shop.model.Product;
import com.rajabuttonstore.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }
    public Product updateProduct(Long id, Product newProductData) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProductData.getName());
                    product.setPrice(newProductData.getPrice());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
