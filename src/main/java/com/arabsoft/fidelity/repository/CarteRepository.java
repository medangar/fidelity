package com.arabsoft.fidelity.repository;
import com.arabsoft.fidelity.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarteRepository extends JpaRepository<Carte,Long> {

    @Query("select count(*) as nbr from Carte c inner join c.client cc where :min < cc.datenaiss and :max > cc.datenaiss")
    Integer countCarteByClientAndAge(@Param("min") LocalDate min,@Param("max") LocalDate max);

    @Query("select sum(c.nbPoints) from Carte c inner join c.client cc where cc.identifiant = :identifiant")
    int findTotalFidelite(@Param("identifiant") String identifiant);
}
