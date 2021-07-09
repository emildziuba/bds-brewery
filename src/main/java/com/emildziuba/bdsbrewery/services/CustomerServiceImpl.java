package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerByUuid(UUID customerUuid) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .name("Tom Sawyer")
                .build();
    }
}
