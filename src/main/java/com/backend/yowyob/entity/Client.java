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
    
    public enum SegmentClient {
        PARTICULIER, ENTREPRISE, REVENDEUR
    }
    
    public enum CanalAquisition {
        WEB, RESEAU, RECOMMANDATION
    }
}