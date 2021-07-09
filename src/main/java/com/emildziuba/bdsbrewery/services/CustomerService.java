package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerByUuid(UUID customerUuid);
}
