package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "carte")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carte_id")
    private Long carteId;
    @Column(name = "date_validite", nullable = false)
    private LocalDate dateValidite;
    @Column(name = "derniere_visite")
    private LocalDate derniereVisite;
    @Column(name = "nb_points", nullable = false)
    private Float nbPoints;
    @Column(name = "statut", nullable = false)
    private String statut;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "id")
    private List<HistoTransaction> transactions;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
