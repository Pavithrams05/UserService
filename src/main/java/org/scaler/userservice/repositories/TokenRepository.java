package org.scaler.userservice.repositories;

import org.scaler.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token save(Token token);


    Optional<Token> findByTokenValue(String value);
}
