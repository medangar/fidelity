package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "statut", nullable = false)
    private boolean statut;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "price", nullable = false)
    private Float price;
    @ManyToMany(mappedBy = "produits", fetch = FetchType.LAZY)
    private List<OffreProduit> Offreproduits = new ArrayList<>();


}

