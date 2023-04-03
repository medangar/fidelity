package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Offre_achat")
public class OffreAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "valeur", nullable = false)
    private int valeur;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "validite", nullable = false)
    private LocalDate validite;
    @Column(name = "sum_min", nullable = false)
    private Float sommeMin;
    @Column(name = "statut", nullable = false)
    private String statut;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

}


