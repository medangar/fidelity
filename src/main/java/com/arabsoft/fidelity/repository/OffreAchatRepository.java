package com.arabsoft.fidelity.repository;

import com.arabsoft.fidelity.model.OffreAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreAchatRepository extends JpaRepository<OffreAchat,Long> {
}
