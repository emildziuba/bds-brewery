package com.emildziuba.bdsbrewery.web.controller;

import com.emildziuba.bdsbrewery.services.BeerService;
import com.emildziuba.bdsbrewery.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
@AllArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerUuid}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerUuid") UUID beerUuid) {
        return new ResponseEntity<>(beerService.getBeerByUuid(beerUuid), HttpStatus.OK);
    }
}
