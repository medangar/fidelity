package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.Produit;

import java.util.List;

public interface ProductService {
    List<Produit> getAllProduit();

    Produit getProduitById(Long id);

    void delete(Long id);

    Produit save(Produit produit);

    void delete(List<Long> ids);
}
