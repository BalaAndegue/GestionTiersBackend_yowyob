package com.backend.yowyob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "tenant")

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name ;
    private String website;
    

    // addresse du tenant 
   
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


    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tiers> tousLesTiers = new ArrayList<>();
    
    // Timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    // Énumérations
    public enum Pays {
        CMR, CG, TC, GB, CI,FR, USA 
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

    

