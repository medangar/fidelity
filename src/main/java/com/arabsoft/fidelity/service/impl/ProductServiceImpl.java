package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.Produit;
import com.arabsoft.fidelity.repository.ProduitRepository;
import com.arabsoft.fidelity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(produitRepository::deleteById);
    }
}
