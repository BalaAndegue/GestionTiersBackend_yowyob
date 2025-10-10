package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends Tiers {
    
    @Enumerated(EnumType.STRING)
    private SegmentClient segment;
    
    private BigDecimal plafondCredit;
    
    @Enumerated(EnumType.STRING)
    private CanalAquisition canalAquisition;
    
    public enum SegmentClient {
        PARTICULIER, ENTREPRISE, REVENDEUR
    }
    
    public enum CanalAquisition {
        WEB, RESEAU, RECOMMANDATION
    }
}