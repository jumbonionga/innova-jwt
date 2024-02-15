package dev.fernando.jwt.domain.repository;

import dev.fernando.jwt.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);
}
