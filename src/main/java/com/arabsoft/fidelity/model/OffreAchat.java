package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "sum_min", nullable = false)
    private Float sommeMin;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

}


