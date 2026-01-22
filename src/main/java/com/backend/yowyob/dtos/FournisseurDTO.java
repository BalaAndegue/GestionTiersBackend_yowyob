package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class FournisseurDTO extends TiersBaseDTO {
    @Schema(description = "Type de fournisseur selon OHADA", example = "EXPLOITATION", allowableValues = {"EXPLOITATION", "GROUPE", "IMMOBILISATIONS", "DIVERS"})
    private String typeFournisseurOhada;

    @Schema(description = "Mode de paiement habituel", example = "VIREMENT", allowableValues = {"VIREMENT", "CHEQUE", "TRAITE"})
    private String modePaiement;
    
    @Schema(description = "Délai de livraison moyen en jours", example = "30 jours")
    private String delaiLivraison;
    
    @Schema(description = "Catégorie principale de produits fournis", example = "ELECTRONIQUE")
    private String produitsPrincipaux;
    
    @Schema(description = "Certifications qualité détenues", example = "ISO 9001, ISO 14001")
    private String certification;
}