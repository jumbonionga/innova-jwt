package dev.fernando.jwt.domain.repository;

import dev.fernando.jwt.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
