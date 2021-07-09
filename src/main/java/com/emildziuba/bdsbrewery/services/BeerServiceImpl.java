package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerByUuid(UUID beerUuid) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerStyle("Pale Ale")
                .beerName("Galaxy Cat")
                .build();
    }
}
