package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "commerciaux")
@Data
@EqualsAndHashCode(callSuper = true)
public class Commercial extends Tiers {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type_commercial")
    private TypeCommercial typeCommercial;
    
    private BigDecimal commission;
    
    @Column(name = "date_debut_contrat")
    private LocalDate dateDebutContrat;
    
    @Column(name = "date_fin_contrat")
    private LocalDate dateFinContrat;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "zones_couvertes")
    private ZoneCouverture zonesCouvertes;
    
    @Enumerated(EnumType.STRING)
    private Specialisation specialisations;
    
    public enum TypeCommercial {
        INTERNE, EXTERNE, INDEPENDANT
    }
    
    public enum ZoneCouverture {
        NORD, SUD, EST, OUEST, INTERNATIONAL
    }
    
    public enum Specialisation {
        B2B, B2C, SECTEUR_PUBLIC, GRANDS_COMPTES
    }
}