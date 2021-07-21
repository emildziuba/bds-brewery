package com.emildziuba.bdsbrewery.services;

import com.emildziuba.bdsbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerByUuid(UUID beerUuid);

    BeerDto saveNewBeer(BeerDto beer);

    void updateBeer(UUID beerUuid, BeerDto beerDto);

    void deleteBeer(UUID beerUuid);
}
