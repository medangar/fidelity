package com.arabsoft.fidelity.repository;
import com.arabsoft.fidelity.model.HistoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoTransactionRepository extends JpaRepository<HistoTransaction,Long> {
}
