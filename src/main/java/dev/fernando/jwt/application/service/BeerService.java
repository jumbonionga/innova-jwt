package dev.fernando.jwt.application.service;

import dev.fernando.jwt.application.exception.DemoSecurityException;
import dev.fernando.jwt.application.lasting.EMessage;
import dev.fernando.jwt.domain.dto.BeerDto;
import dev.fernando.jwt.domain.entity.Beer;
import dev.fernando.jwt.domain.repository.IBeerRepository;
import org.springframework.stereotype.Service;

@Service
public record BeerService(
        IBeerRepository beerRepository
) {
    public void createBeer(BeerDto beerDto) {
        Beer beer = Beer.builder()
                .name(beerDto.name())
                .type(beerDto.type())
                .alcoholGrade(beerDto.alcoholGrade())
                .build();
        System.out.println("Cerveza a guardar: " + beer);
        
        // Llamar a la interfaz del repositorio save
        beerRepository.save(beer);
    }
    
    public BeerDto findBeerById(Integer id) throws DemoSecurityException {
        Beer beer = beerRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new BeerDto(
                beer.getId(),
                beer.getName(),
                beer.getAlcoholGrade(),
                beer.getType()
        );
    }
}
