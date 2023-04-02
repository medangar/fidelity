package com.arabsoft.fidelity.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Offre_produit")
public class OffreProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long offreId;
    @Column(name = "valeur", nullable = false)
    private int valeur;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @ManyToMany
    private List<Produit> produits = new ArrayList<>();

    public OffreProduit() {

    }

    public OffreProduit(int valeur) {
        this.valeur = valeur;
    }

    public Long getOffreId() {
        return offreId;
    }

    public void setOffreId(Long offreId) {
        this.offreId = offreId;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Offre par produit[id=" + offreId + ",valeur offre=" + valeur + "]";
    }
}
