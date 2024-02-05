package dev.fernando.jwt.domain.repository;

import dev.fernando.jwt.domain.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeerRepository extends JpaRepository<Beer,Integer> {
}
