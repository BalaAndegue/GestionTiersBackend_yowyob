package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "fournisseurs")
@Data
@EqualsAndHashCode(callSuper = true)
public class Fournisseur extends Tiers {
    
    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;
    
    private String delaiLivraison;
    
    @Enumerated(EnumType.STRING)
    private ProduitPrincipal produitsPrincipaux;
    
    private String certification;
    
    public enum ModePaiement {
        VIREMENT, CHEQUE, TRAITE
    }
    
    public enum ProduitPrincipal {
        ELECTRONIQUE, MATERIEL, LOGICIEL
    }
}