package com.arabsoft.fidelity.model;
import jakarta.persistence.*;
import java.util.Date;
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

    public HistoTransaction() {

    }

    public HistoTransaction(Float soldeInit, Date dateTransaction, Float soldeFnl, String typeTransaction) {
        this.soldeInit = soldeInit;
        this.dateTransaction = dateTransaction;
        this.soldeFnl = soldeFnl;
        this.typeTransaction = typeTransaction;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSoldeInit() {
        return soldeInit;
    }

    public void setSoldeInit(Float soldeInit) {
        this.soldeInit = soldeInit;
    }


    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Float getSoldeFnl() {
        return soldeFnl;
    }

    public void setSoldeFnl(Float soldeFnl) {
        this.soldeFnl = soldeFnl;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    @Override
    public String toString() {
        return "historique de transaction [id=" + id + ",solde initiale=" + soldeInit + ",date de transaction=" + dateTransaction + ",solde finale="
                + soldeFnl + ",typde de transaction=" + typeTransaction + "[";
    }
}
