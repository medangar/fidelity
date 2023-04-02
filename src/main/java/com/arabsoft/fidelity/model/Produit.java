package com.arabsoft.fidelity.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long produitId;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "valeurStock", nullable = false)
    private int valStock;
    @ManyToMany(mappedBy = "produits", fetch = FetchType.LAZY)
    private List<OffreProduit> Offreproduits = new ArrayList<>();

    public Produit() {

    }

    public Produit(String nom, int valStock) {
        this.nom = nom;
        this.valStock = valStock;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValStock() {
        return valStock;
    }

    public void setValStock(int valStock) {
        this.valStock = valStock;
    }

    public List<OffreProduit> getOffreproduits() {
        return Offreproduits;
    }

    public void setOffreproduits(List<OffreProduit> offreproduits) {
        Offreproduits = offreproduits;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "produitId=" + produitId +
                ", nom='" + nom + '\'' +
                ", valStock=" + valStock +
                ", Offreproduits=" + Offreproduits +
                '}';
    }
}

