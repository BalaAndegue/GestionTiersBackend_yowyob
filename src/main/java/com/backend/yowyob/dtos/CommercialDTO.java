package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class CommercialDTO extends TiersBaseDTO {
    @Schema(description = "Type de personnel selon OHADA", example = "PERSONNEL", allowableValues = {"PERSONNEL", "ORGANISMES_SOCIAUX", "ETAT", "DIVERS"})
    private String typePersonnelOhada;

    @Schema(description = "Type de commercial", example = "INTERNE", allowableValues = {"INTERNE", "EXTERNE", "INDEPENDANT"})
    private String typeCommercial;
    
    @Schema(description = "Pourcentage de commission", example = "5.0")
    private BigDecimal commission;
    
    @Schema(description = "Date de début du contrat", example = "2023-01-01")
    private String dateDebutContrat;
    
    @Schema(description = "Date de fin du contrat (si CDD)", example = "2024-01-01")
    private String dateFinContrat;
    
    @Schema(description = "Zones géographiques couvertes", example = "NORD, OUEST")
    private String zonesCouvertes;
    
    @Schema(description = "Spécialisations du commercial", example = "B2B")
    private String specialisations;
}

