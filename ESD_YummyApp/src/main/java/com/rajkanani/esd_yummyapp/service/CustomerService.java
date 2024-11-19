package com.rajkanani.esd_yummyapp.service;


import com.rajkanani.esd_yummyapp.dto.CustomerRequest;
import com.rajkanani.esd_yummyapp.dto.CustomerResponse;
import com.rajkanani.esd_yummyapp.dto.LoginRequest;
import com.rajkanani.esd_yummyapp.entity.Customer;
import com.rajkanani.esd_yummyapp.entity.Product;
import com.rajkanani.esd_yummyapp.exception.CustomerNotFoundException;
import com.rajkanani.esd_yummyapp.helper.EncryptionService;
import com.rajkanani.esd_yummyapp.helper.JWTHelper;
import com.rajkanani.esd_yummyapp.mapper.CustomerMapper;
import com.rajkanani.esd_yummyapp.repo.CustomerRepo;
import com.rajkanani.esd_yummyapp.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }

    @Autowired
    private ProductRepo productRepo;

    public String getProductsWithPriceRange() {
        List<Product> products = productRepo.findTop2ByPriceBetweenOrderByPriceAsc();
        StringBuilder pro = new StringBuilder();
        for(Product product : products) {
            pro.append(product.getName()).append(",");
        }
        return pro.toString();
    }

}
