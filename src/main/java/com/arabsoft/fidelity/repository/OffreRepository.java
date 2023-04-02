package com.arabsoft.fidelity.repository;
import com.arabsoft.fidelity.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Long> {
}
