package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.HistoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoTransactionRepository extends JpaRepository<HistoTransaction, Long> {

    @Query(nativeQuery = true, value = "select sum(h.solde_finale - h.solde_initiale) as sumPoints " +
            " from hist_transaction  h " +
            " where h.date_transaction >= :now and h.date_transaction< :tomorrow")
    Integer findTotalPointsPerDay(@Param("now") LocalDate now, @Param("tomorrow") LocalDate plusDays);

    @Query(nativeQuery = true, value = "select count(*) as numberTransaction " +
            " from hist_transaction  h " +
            " where h.date_transaction >= :now and h.date_transaction< :tomorrow")
    Integer findTotalTransactionsPerDay(@Param("now") LocalDate now, @Param("tomorrow") LocalDate plusDays);

    @Query(nativeQuery = true, value = "select count(*) as numberUser from ( " +
            "select distinct c.carte_id from carte c " +
            "inner join hist_transaction h on c.carte_id = h.carte_id " +
            "where h.date_transaction >= :now and h.date_transaction< :tomorrow) f")
    Integer findUserTransactionPerDay(@Param("now") LocalDate now, @Param("tomorrow") LocalDate plusDays);


    @Query(nativeQuery = true, value = "select sum(abs(h.solde_finale - h.solde_initiale)) as sum " +
            "from hist_transaction h  " +
            "where  h.type_transaction = :type " +
            "and h.date_transaction >= :now and h.date_transaction < :tomorrow")
    Integer getTotalPtsByMonth(@Param("type") String type,@Param("now") LocalDate now, @Param("tomorrow") LocalDate plusDays);

    @Query("SELECT t FROM HistoTransaction t ORDER BY t.dateTransaction DESC")
    List<HistoTransaction> findLastTransactions();

    @Query("SELECT t FROM HistoTransaction t inner join t.carte c inner join c.client cl where cl.identifiant = :identifiant ORDER BY t.dateTransaction DESC")
    List<HistoTransaction> findLastTransactionsByClient(@Param("identifiant") String identifiant);

    @Query("SELECT count(*) as nbr FROM HistoTransaction t inner join t.carte c inner join c.client cl where cl.sexe = :sexe")
    Integer getNumberTransactionBySexe(@Param("sexe") String sexe);

    @Query(nativeQuery = true, value ="select sum(abs(h.solde_finale - h.solde_initiale)) as sum " +
            "from hist_transaction h " +
            "inner join carte c on c.carte_id = h.carte_id " +
            "inner join client cl on cl.id = c.client_id " +
            "where cl.identifiant = :identifiant and  h.type_transaction = :type " +
            "and h.date_transaction >= :firstDay and h.date_transaction < :lastDay")
    Integer calculPointByClientAndTypeTransaction(@Param("identifiant") String identifiant,
                                                  @Param("type") String type,
                                                  @Param("firstDay") LocalDate firstDay,
                                                  @Param("lastDay") LocalDate lastDay);


}
