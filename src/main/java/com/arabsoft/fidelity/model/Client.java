package com.arabsoft.fidelity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@PrimaryKeyJoinColumn(name = "id")
@Entity
@Table(name = "client",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"identifiant"})})
public class Client extends User {
    @Column(name = "identifiant", nullable = false,  unique = true)
    public String identifiant;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code_postale")
    private String codepostale;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carte_id")
    private List<Carte> cartes;
}






