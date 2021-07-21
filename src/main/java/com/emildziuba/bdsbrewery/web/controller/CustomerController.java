package com.emildziuba.bdsbrewery.web.controller;

import com.emildziuba.bdsbrewery.services.CustomerService;
import com.emildziuba.bdsbrewery.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedCustomer.getUuid().toString());
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerUuid}")
    public ResponseEntity<HttpStatus> updateCustomer(@PathVariable("customerUuid") UUID customerUuid, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerUuid, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerUuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerUuid") UUID customerUuid) {
        customerService.deleteCustomer(customerUuid);
    }
}
