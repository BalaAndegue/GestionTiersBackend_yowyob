package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tiers")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Tiers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Informations de base
    @Column(nullable = false)
    private String name;
    
    private String shortName;
    private String longName;
    
    @Column(length = 1000)
    private String description;
    
    // Coordonnées
    private String email;
    private String phoneNumber;
    private String website;
    
    // Adresse
    private String address;
    private String complement;
    private String postalCode;
    private String city;
    
    @Enumerated(EnumType.STRING)
    private Pays pays;
    
    // Informations entreprise
    @Enumerated(EnumType.STRING)
    private SecteurActivite secteurActivite;
    
    @Enumerated(EnumType.STRING)
    private TailleEntreprise tailleEntreprise;
    
    private LocalDate dateCreation;
    private String registreCommerce;
    private String numeroFiscal;
    
    // Canal préféré
    @Enumerated(EnumType.STRING)
    private CanalPrefere canalPrefere;
    
    @Enumerated(EnumType.STRING)
    private TypeEntreprise typeEntreprise;
    
    // Timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    // Énumérations
    public enum Pays {
        CMR, CG, TC, GB, CI
    }
    
    public enum SecteurActivite {
        IT, FINANCE, SANTE, INDUSTRIE, COMMERCE
    }
    
    public enum TailleEntreprise {
        MICRO, PME, ETI, GE
    }
    
    public enum CanalPrefere {
        EMAIL, PHONE, COURRIER, IN_PERSON
    }
    
    public enum TypeEntreprise {
        PARTICULIER, ENTREPRISE, REVENDEUR
    }
}