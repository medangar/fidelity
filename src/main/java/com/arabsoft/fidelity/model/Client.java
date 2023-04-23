package com.arabsoft.fidelity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @Column(name = "identifiant", nullable = false, unique = true)
    public String identifiant;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code_postale")
    private String codepostale;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "datenaissance")
    private LocalDate datenaiss;
    @JsonIgnore
    @OneToMany
    private List<Carte> cartes;
}






