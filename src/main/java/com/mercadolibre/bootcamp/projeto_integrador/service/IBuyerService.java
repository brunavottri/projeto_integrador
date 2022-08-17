package com.mercadolibre.bootcamp.projeto_integrador.service;

import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerRequestDto;
import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerResponseDto;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;

import java.util.List;

public interface IBuyerService {

    List<Buyer> getAllBuyers();

    BuyerResponseDto createBuyer(BuyerRequestDto request);

    BuyerResponseDto updateBuyer(BuyerRequestDto request, long id);

    Void deleteBuyer(long id);

}
