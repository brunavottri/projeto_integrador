package com.mercadolibre.bootcamp.projeto_integrador.controller;

import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerRequestDto;
import com.mercadolibre.bootcamp.projeto_integrador.dto.BuyerResponseDto;
import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import com.mercadolibre.bootcamp.projeto_integrador.service.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BuyerController {

    @Autowired
    private IBuyerService buyerService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value="/buyer/getall")
    public ResponseEntity<List<Buyer>> getAllBuyers () {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.getAllBuyers());
    }

    @PostMapping(value = "/buyer/create")
    public ResponseEntity<BuyerResponseDto> createBuyer (@RequestBody BuyerRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerService.createBuyer(request));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(value = "/buyer/update")
    public ResponseEntity<BuyerResponseDto> updateBuyer (@RequestBody BuyerRequestDto request, @RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.updateBuyer(request, id));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping(value = "/buyer/delete")
    public ResponseEntity<Void> deleteBuyer (@RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.deleteBuyer(id));
    }
}

