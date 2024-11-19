package com.rajkanani.esd_yummyapp.service;

import com.rajkanani.esd_yummyapp.dto.ProductRequest;
import com.rajkanani.esd_yummyapp.entity.Product;
import com.rajkanani.esd_yummyapp.helper.JWTHelper;
import com.rajkanani.esd_yummyapp.mapper.ProductMapper;
import com.rajkanani.esd_yummyapp.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final JWTHelper jwtHelper;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public String addProduct(ProductRequest product) {
        Product product1 = productMapper.toProduct(product);
        productRepo.save(product1);
        return "Product added";
    }

    public Product getProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        return product;
    }

    public String updateProduct(ProductRequest product) {
        Product product_1 = getProduct(product.name());
        product_1.setPrice(product.price());
        productRepo.save(product_1);
        return "Product updated";
    }


    public String deleteProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        productRepo.delete(product);
        return "Product deleted";
    }


}
