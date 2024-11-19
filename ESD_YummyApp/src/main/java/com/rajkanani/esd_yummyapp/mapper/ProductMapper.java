package com.rajkanani.esd_yummyapp.mapper;

import com.rajkanani.esd_yummyapp.dto.ProductRequest;
import com.rajkanani.esd_yummyapp.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct (ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }
}
