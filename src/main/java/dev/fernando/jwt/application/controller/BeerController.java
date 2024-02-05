package dev.fernando.jwt.application.controller;

import dev.fernando.jwt.application.service.BeerService;
import dev.fernando.jwt.domain.dto.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.fernando.jwt.application.exception.DemoSecurityException;

@RestController
@RequestMapping("/api/v1/beer")
public record BeerController(
        BeerService beerService
) {
    @PostMapping
    public ResponseEntity<?> registerBeer(@RequestBody BeerDto beerDto) {
        beerService.createBeer(beerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> findBeerById(@PathVariable Integer id) throws DemoSecurityException {
        BeerDto beerDto = beerService.findBeerById(id);
        return new ResponseEntity<>(beerDto,HttpStatus.FOUND);
    }
}
