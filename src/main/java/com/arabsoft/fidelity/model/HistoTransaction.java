package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "hist_transaction")
public class HistoTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "solde_initiale", nullable = false)
    private Float soldeInit;
    @Column(name = "date_transaction", nullable = false)
    private Date dateTransaction;
    @Column(name = "solde_finale", nullable = false)
    private Float soldeFnl;
    @Column(name = "type_transaction", nullable = false)
    private String typeTransaction;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private Carte carte;

}
