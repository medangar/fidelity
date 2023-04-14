package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.OffreAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreAchatRepository extends JpaRepository<OffreAchat, Long> {

    @Query("SELECT oa FROM OffreAchat oa inner join oa.offre o WHERE o.id = :offreId and :total >= oa.sommeMin  ORDER BY valeur DESC")
    List<OffreAchat> getLastOffreAchatByOffreAndMinValue(@Param("offreId") Long offreId, @Param("total") Float total);

}
