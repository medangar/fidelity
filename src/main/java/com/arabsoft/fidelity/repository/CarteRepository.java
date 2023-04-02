package com.arabsoft.fidelity.repository;
import com.arabsoft.fidelity.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteRepository extends JpaRepository<Carte,Long> {
}
