package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prospects")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor
public class Prospect extends Tiers {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "source_prospect")
    private SourceProspect sourceProspect;
    
    @Enumerated(EnumType.STRING)
    private Potentiel potentiel;
    
    @Column(name = "date_conversion")
    private LocalDate dateConversion;
    
    private Integer probabilite;
    
    @Column(name = "notes_prospect", length = 2000)
    private String notesProspect;
    
    public enum SourceProspect {
        SITE_WEB, RESEAU_SOCIAL, SALON, RECOMMANDATION
    }
    
    public enum Potentiel {
        FAIBLE, MOYEN, ELEVE, STRATEGIQUE
    }
}