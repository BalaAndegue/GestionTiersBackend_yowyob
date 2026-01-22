package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class ProspectDTO extends TiersBaseDTO {
    @Schema(description = "Type de prospect selon OHADA", example = "ORDINAIRE", allowableValues = {"ORDINAIRE", "STRATEGIQUE", "PARTENAIRE"})
    private String typeProspectOhada;

    @Schema(description = "Source du prospect", example = "SITE_WEB")
    private String sourceProspect;
    
    @Schema(description = "Potentiel estimé du prospect", example = "ELEVE", allowableValues = {"FAIBLE", "MOYEN", "ELEVE", "STRATEGIQUE"})
    private String potentiel;
    
    @Schema(description = "Date prévue ou effective de conversion", example = "2023-12-31")
    private String dateConversion;
    
    @Schema(description = "Probabilité de conversion (%)", example = "75")
    private Integer probabilite;
    
    @Schema(description = "Notes et commentaires sur le prospect", example = "Intéressé par le module CRM, budget validé")
    private String notesProspect;
}