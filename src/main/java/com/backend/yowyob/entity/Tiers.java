package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tiers")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Tiers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    // Informations de base
    @Column(nullable = false)
    private String name;

    private String NUI;
    
    
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
    private String enterpriseName ; 
    
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

    //activation / desactivation d'un tiers
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean active =true;

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

   public void activate() {
        this.active = true;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    public boolean isActive() {
        return this.active;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}