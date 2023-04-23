package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.OffreProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreProduitRepository extends JpaRepository<OffreProduit,Long> {
    @Query(nativeQuery = true , value = "select  sum(op.valeur) " +
            "from Produit p " +
            "inner join offre_produit_produits opp on opp.produits_id = p.id " +
            "inner join offre_produit op on op.id = opp.offreproduits_id " +
            "inner join offre o on o.id = op.offre_id " +
            "WHERE o.id = :offreId and p.id in (:ids)")
    float getOffreProduitByOffre(@Param("offreId") Long offreId, @Param("ids") List<Long> productsIds);
}
