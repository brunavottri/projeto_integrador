package com.mercadolibre.bootcamp.projeto_integrador.service;

import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerRequestDto;
import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerResponseDto;
import com.mercadolibre.bootcamp.projeto_integrador.exceptions.AlreadyExistsException;
import com.mercadolibre.bootcamp.projeto_integrador.exceptions.NotFoundException;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import com.mercadolibre.bootcamp.projeto_integrador.repository.IBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService implements IBuyerService{
    @Autowired
    IBuyerRepository buyerRepository;

    @Transactional
    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Transactional
    @Override
    public BuyerResponseDto createBuyer(BuyerRequestDto request) {
        Optional<Buyer> foundBuyer = findBuyerbyUsername(request.getUsername());
        if(foundBuyer.isPresent()) throw new AlreadyExistsException("Username");

        Buyer buyer = new Buyer();
        buyer.setUsername(request.getUsername());
        buyer.setPassword(passwordEncoder().encode(request.getPassword()));
        buyerRepository.save(buyer);

        return new BuyerResponseDto(buyer.getBuyerId(),buyer.getUsername(), buyer.getPassword());
    }

    @Transactional
    @Override
    public BuyerResponseDto updateBuyer(BuyerRequestDto request, long id) {
        Optional<Buyer> foundBuyer = buyerRepository.findById(id);
        if (foundBuyer.isEmpty()) throw new NotFoundException("Buyer");

        foundBuyer.get().setUsername(request.getUsername());
        foundBuyer.get().setPassword(passwordEncoder().encode(request.getPassword()));
        buyerRepository.save(foundBuyer.get());

        return new BuyerResponseDto(foundBuyer.get().getBuyerId(), foundBuyer.get().getUsername(), foundBuyer.get().getPassword());
    }

    @Transactional
    @Override
    public Void deleteBuyer(long id) {
        Optional<Buyer> foundBuyer = buyerRepository.findById(id);
        if (foundBuyer.isEmpty()) throw new NotFoundException("Buyer");

        buyerRepository.delete(foundBuyer.get());

        return null;
    }

    private Optional<Buyer> findBuyerbyUsername(String username) {
        return buyerRepository.findBuyerByUsername(username);
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 }
