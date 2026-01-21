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
    
    private BigDecimal commission;
    private String dateDebutContrat;
    private String dateFinContrat;
    private String zonesCouvertes;
    private String specialisations;
}

