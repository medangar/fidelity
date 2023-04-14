package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.OffreProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreProduitRepository extends JpaRepository<OffreProduit,Long> {
    @Query("SELECT op FROM OffreProduit op inner join op.offre o left join op.produits p WHERE o.id = :offreId and p.id in (:ids)")
    List<OffreProduit> getOffreProduitByOffre(@Param("offreId") Long offreId, @Param("ids") List<Long> productsIds);
}
