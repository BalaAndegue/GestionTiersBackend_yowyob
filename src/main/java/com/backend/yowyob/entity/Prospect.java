package com.backend.yowyob.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "prospects")
@Data
@EqualsAndHashCode(callSuper = true)
public class Prospect extends Tiers {
    
    @Enumerated(EnumType.STRING)
    private SourceProspect sourceProspect;
    
    @Enumerated(EnumType.STRING)
    private Potentiel potentiel;
    
    private LocalDate dateConversion;
    private Integer probabilite;
    
    @Column(length = 2000)
    private String notesProspect;
    
    public enum SourceProspect {
        SITE_WEB, RESEAU_SOCIAL, SALON, RECOMMANDATION
    }
    
    public enum Potentiel {
        FAIBLE, MOYEN, ELEVE, STRATEGIQUE
    }
}
