package com.mercadolibre.bootcamp.projeto_integrador.util;

import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerRequestDto;
import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerResponseDto;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;

import java.util.ArrayList;
import java.util.List;

public class BuyerGenerator {
    public static List<Buyer> newBuyersList() {
        List<Buyer> buyerList = new ArrayList<>();
        buyerList.add(Buyer.builder()
        .buyerId(1L)
        .username("Fulano")
        .password("$2a$12$bW6aKLtcwAujNMJQ2SpTwu2vtprVRhJNZPHt7wLGCBZuTqzcHrVYq")
        .build());

        return buyerList;
    }

    public static BuyerRequestDto newBuyerRequestDto() {
        return BuyerRequestDto.builder()
        .username("Fulano")
        .password("123456")
        .build();
    }
}
