package com.arabsoft.fidelity.repository;
import com.arabsoft.fidelity.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


}
