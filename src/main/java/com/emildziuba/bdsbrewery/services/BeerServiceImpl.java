package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerByUuid(UUID beerUuid) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerStyle("Pale Ale")
                .beerName("Galaxy Cat")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerUuid, BeerDto beerDto) {
        log.info("Beer {} updated", beerUuid.toString());
    }

    @Override
    public void deleteBeer(UUID beerUuid) {
        log.info("Beer {} deleted", beerUuid.toString());
    }


}
