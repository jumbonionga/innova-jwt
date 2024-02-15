package dev.fernando.jwt.domain.dto;

public record AuthenticationDto(
        String email,
        String password
) {
}
