package com.mercadolibre.bootcamp.projeto_integrador.repository;

import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBuyerRepository extends JpaRepository<Buyer, Long> {
    Optional<Buyer> findBuyerByUsername(String username);
}
