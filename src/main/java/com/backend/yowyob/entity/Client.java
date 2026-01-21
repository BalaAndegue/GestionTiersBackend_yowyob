package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor
public class Client extends Tiers {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "segment")
    private SegmentClient segment;
    
    @Column(name = "plafond_credit")
    private BigDecimal plafondCredit;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "canal_aquisition")
    private CanalAquisition canalAquisition;
    
    // Nouveaux champs spécifiques aux clients
    @Column(name = "numero_tva")
    private String numeroTVA;

    @Column(name = "est_assujetti_tva", columnDefinition = "boolean default false")
    private Boolean estAssujettiTVA = false;
    
    @Column(name = "vente_detail", columnDefinition = "boolean default false")
    private Boolean venteDetail = false;
    
    @Column(name = "vente_demi_gros", columnDefinition = "boolean default false")
    private Boolean venteDemiGros = false;
    
    @Column(name = "vente_gros", columnDefinition = "boolean default false")
    private Boolean venteGros = false;
    
    @Column(name = "vente_super_gros", columnDefinition = "boolean default false")
    private Boolean venteSuperGros = false;
    
   
    @Enumerated(EnumType.STRING)
    @Column(name = "type_client_ohada")
    private TypeClientOhada typeClientOhada;

    public enum SegmentClient {
        PARTICULIER, ENTREPRISE, REVENDEUR
    }

    public enum TypeClientOhada {
        ORDINAIRE, ETAT, GROUPE, DOUTEUX, DIVERS
    }
    
    public enum CanalAquisition {
        WEB, RESEAU, RECOMMANDATION
    }
}