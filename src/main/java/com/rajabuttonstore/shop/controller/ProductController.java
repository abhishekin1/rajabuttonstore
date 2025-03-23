package com.rajabuttonstore.shop.controller;

import com.rajabuttonstore.shop.model.Product;
import com.rajabuttonstore.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @GetMapping("/test")
//    public String getAllProducts1() {
//        return "Hello MFrs";
//    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product newProductData) {
        return productService.updateProduct(id, newProductData);
    }
}