package com.rajkanani.esd_yummyapp.mapper;

import com.rajkanani.esd_yummyapp.dto.CustomerRequest;
import com.rajkanani.esd_yummyapp.dto.CustomerResponse;
import com.rajkanani.esd_yummyapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
