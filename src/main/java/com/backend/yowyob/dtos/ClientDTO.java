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
    
    @Schema(description = "Plafond de crédit autorisé", example = "1000000.00")
    private BigDecimal plafondCredit;
    
    @Schema(description = "Canal d'acquisition", example = "LINKEDIN", allowableValues = {"LINKEDIN", "FACEBOOK", "SALON", "BOUCHE_A_OREILLE"})
    private String canalAquisition;
    
    @Schema(description = "Autorisation vente au détail", example = "true")
    private Boolean venteDetail;
    
    @Schema(description = "Autorisation vente demi-gros", example = "false")
    private Boolean venteDemiGros;
    
    @Schema(description = "Autorisation vente en gros", example = "false")
    private Boolean venteGros;
    
    @Schema(description = "Autorisation vente super-gros", example = "false")
    private Boolean venteSuperGros;
    
    @Schema(description = "Assujetti à la TVA", example = "true")
    private Boolean estAssujettiTVA;
}

