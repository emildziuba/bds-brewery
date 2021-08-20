package com.emildziuba.bdsbrewery.web.controller;

import com.emildziuba.bdsbrewery.services.BeerService;
import com.emildziuba.bdsbrewery.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity postBeer(@RequestBody BeerDto beer) {
        BeerDto savedDto = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerUuid}")
    public ResponseEntity updateBeer(@PathVariable("beerUuid") UUID beerUuid, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerUuid, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerUuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerUuid") UUID beerUuid) {
        beerService.deleteBeer(beerUuid);
    }
}
