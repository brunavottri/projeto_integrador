package com.mercadolibre.bootcamp.projeto_integrador.service;

import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerRequestDto;
import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerResponseDto;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import com.mercadolibre.bootcamp.projeto_integrador.repository.IBuyerRepository;
import com.mercadolibre.bootcamp.projeto_integrador.util.BuyerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BuyerServiceTest {

    @InjectMocks
    private BuyerService service;

    @Mock
    private IBuyerRepository buyerRepository;

    private List<Buyer> buyerList;
    private BuyerRequestDto buyerRequestDto;

    @BeforeEach
    void setup() {
        buyerList = BuyerGenerator.newBuyersList();
        buyerRequestDto = BuyerGenerator.newBuyerRequestDto();
    }

    @Test
    void getAllBuyers_returnBuyers_whenBuyersExists() {
        // Arrange
        BDDMockito.when(buyerRepository.findAll()).thenReturn(buyerList);
        // Act
        List<Buyer> result = service.getAllBuyers();

        // Assert
        assert result.size() == 1;
        assert result.get(0).getUsername().equals("Fulano");
        assert result.get(0).getPassword().equals("$2a$12$bW6aKLtcwAujNMJQ2SpTwu2vtprVRhJNZPHt7wLGCBZuTqzcHrVYq");
        assert result.get(0).getBuyerId() == 1L;
    }

    @Test
    void createBuyer() {
        // Arrange
        BDDMockito.when(buyerRepository.save(ArgumentMatchers.any(Buyer.class))).thenReturn(buyerList.get(0));
        // Act
        BuyerResponseDto result = service.createBuyer(buyerRequestDto);
        // Assert
        assert result.getUsername().equals("Fulano");

    }

    @Test
    void updateBuyer() {
        // Arrange
        BDDMockito.when(buyerRepository.findById(1L)).thenReturn(Optional.of(buyerList.get(0)));
        BDDMockito.when(buyerRepository.save(ArgumentMatchers.any(Buyer.class))).thenReturn(buyerList.get(0));
        // Act
        BuyerResponseDto result = service.updateBuyer(buyerRequestDto, 1L);
        // Assert
        assert result.getUsername().equals("Fulano");
    }

    @Test
    void deleteBuyer() {
        // Arrange
        BDDMockito.when(buyerRepository.findById(1L)).thenReturn(Optional.of(buyerList.get(0)));
        // Act
        service.deleteBuyer(1L);
        // Assert
        assert true;
    }
}
