package dev.fernando.jwt.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BeerDto(
        Integer id,
        String name,
        Double alcoholGrade,
        String type
) {
}
