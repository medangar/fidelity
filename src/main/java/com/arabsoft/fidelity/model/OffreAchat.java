package com.arabsoft.fidelity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Offre_achat")
public class OffreAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long offreId;
    @Column(name = "valeur", nullable = false)
    private int valeur;
    @Column(name = "sum_min", nullable = false)
    private Float sommemin;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    public OffreAchat() {

    }

    public OffreAchat(int valeur, Float sommemin) {
        this.valeur = valeur;
        this.sommemin = sommemin;
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

    public Float getSommemin() {
        return sommemin;
    }

    public void setSommemin(Float sommemin) {
        this.sommemin = sommemin;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    @Override
    public String toString() {
        return "OffreAchat{" +
                "offreId=" + offreId +
                ", valeur=" + valeur +
                ", sommemin=" + sommemin +
                ", offre=" + offre +
                '}';
    }
}


