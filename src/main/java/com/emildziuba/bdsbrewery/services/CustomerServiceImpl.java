package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerByUuid(UUID customerUuid) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .name("Tom Sawyer")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        customerDto.setUuid(UUID.randomUUID());
        return customerDto;
    }

    @Override
    public void updateCustomer(UUID customerUuid, CustomerDto customerDto) {
        log.info("Customer {} updated", customerUuid.toString());
    }

    @Override
    public void deleteCustomer(UUID customerUuid) {
        log.info("Customer {} deleted", customerUuid.toString());
    }
}
