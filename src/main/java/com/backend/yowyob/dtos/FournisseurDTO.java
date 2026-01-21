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
    
    private String delaiLivraison;
    private String produitsPrincipaux;
    private String certification;
}