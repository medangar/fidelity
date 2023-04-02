package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Produit;
import com.arabsoft.fidelity.request.DeleteRequest;
import com.arabsoft.fidelity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/produit")
@RequiredArgsConstructor
@RestController
public class ProduitController {
    private final ProductService productService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return productService.getAllProduit();
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable(value = "id") Long id) {
        return productService.getProduitById(id);
    }

    @PostMapping
    private Produit saveProduit(@RequestBody Produit produit) {
        System.err.println(produit);
        return productService.save(produit);
    }

    @PutMapping
    private Produit update(@RequestBody Produit produit) {
        System.err.println(produit);
        return productService.save(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable(value = "id") Long id) {
        productService.delete(id);
    }

    @DeleteMapping
    public void deleteProduits(@RequestBody DeleteRequest productIds) {
        productService.delete(productIds.getIds());
    }
}
