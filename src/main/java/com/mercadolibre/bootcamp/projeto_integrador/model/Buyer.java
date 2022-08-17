package com.mercadolibre.bootcamp.projeto_integrador.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long buyerId;

    @Column(length = 45, unique = true)
    private String username;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<PurchaseOrder> purchaseOrders;

    @Column(length = 100)
    private String password;
}