package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fournisseurs")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor
public class Fournisseur extends Tiers {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "mode_paiement")
    private ModePaiement modePaiement;
    
    @Column(name = "delai_livraison")
    private String delaiLivraison;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "produits_principaux")
    private ProduitPrincipal produitsPrincipaux;
    
    private String certification;
    
    public enum ModePaiement {
        VIREMENT, CHEQUE, TRAITE
    }
    
    public enum ProduitPrincipal {
        ELECTRONIQUE, MATERIEL, LOGICIEL
    }
}