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
    private TypeCommercial typeCommercial;
    
    private BigDecimal commission;
    
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    
    @Enumerated(EnumType.STRING)
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