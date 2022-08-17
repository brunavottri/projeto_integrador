package com.mercadolibre.bootcamp.projeto_integrador.authentication.security;

import com.mercadolibre.bootcamp.projeto_integrador.exceptions.NotFoundException;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import com.mercadolibre.bootcamp.projeto_integrador.repository.IBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomBuyerDetailsService implements UserDetailsService {

    @Autowired
    IBuyerRepository buyerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Buyer> foundBuyer = buyerRepository.findBuyerByUsername(username);
        if (foundBuyer.isEmpty()) throw new NotFoundException("Buyer");

        return BuyerPrincipal.create(foundBuyer.get());
    }
}
