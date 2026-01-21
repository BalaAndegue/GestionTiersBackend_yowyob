package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDTO extends TiersBaseDTO {
    @Schema(description = "Type de client selon la norme OHADA", example = "ORDINAIRE", allowableValues = {"ORDINAIRE", "ETAT", "GROUPE", "DOUTEUX", "DIVERS"})
    private String typeClientOhada;

    @Schema(description = "Segment client", example = "ENTREPRISE", allowableValues = {"PARTICULIER", "ENTREPRISE", "REVENDEUR"})
    private String segment;
    
    private BigDecimal plafondCredit;
    private String canalAquisition;
}

