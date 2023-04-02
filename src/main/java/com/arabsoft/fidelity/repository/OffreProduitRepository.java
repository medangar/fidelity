package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.OffreProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreProduitRepository extends JpaRepository<OffreProduit,Long> {
}
