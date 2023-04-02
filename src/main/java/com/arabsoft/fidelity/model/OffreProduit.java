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
@Table(name = "Offre_produit")
public class OffreProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "valeur", nullable = false)
    private int valeur;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @ManyToMany
    private List<Produit> produits = new ArrayList<>();


}
