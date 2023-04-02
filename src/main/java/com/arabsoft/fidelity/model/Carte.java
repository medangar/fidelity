package com.arabsoft.fidelity.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carte")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carte_id")
    private Long carteId;
    @Column(name = "date_validite", nullable = false)
    private Date dateValidite;

    @Column(name = "derniere_visite", nullable = false)
    private Date derniereVisite;
    @Column(name = "nb_points", nullable = false)
    private Float nbPoints;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<HistoTransaction> transactions;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    public Carte() {

    }

    public Carte(Date dateValidite, Date derniereVisite, Float nbPoints) {
        this.derniereVisite = derniereVisite;
        this.dateValidite = dateValidite;
        this.nbPoints = nbPoints;
    }

    public Long getCarteId() {
        return carteId;
    }

    public void setEmployeeId(Long carteId) {
        this.carteId = carteId;
    }

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }


    public Date getDerniereVisite() {
        return derniereVisite;
    }

    public void setDerniereVisite(Date derniereVisite) {
        this.derniereVisite = derniereVisite;
    }


    public Float getNbpoints() {
        return nbPoints;
    }

    public void setNbPoints(Float nbPoints) {
        this.nbPoints = nbPoints;
    }

    @Override
    public String toString() {
        return "Carte [id=" + carteId + ", date validité=" + dateValidite + ", derniére visite=" + derniereVisite + ", nombre des points initiale=" + nbPoints
                + "]";
    }
}
