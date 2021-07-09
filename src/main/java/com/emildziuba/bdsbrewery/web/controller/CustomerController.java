package com.emildziuba.bdsbrewery.web.controller;

import com.emildziuba.bdsbrewery.services.CustomerService;
import com.emildziuba.bdsbrewery.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerUuid}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerUuid") UUID customerUuid) {
        return new ResponseEntity<>(customerService.getCustomerByUuid(customerUuid), HttpStatus.OK);
    }
}
