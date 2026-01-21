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
    
    private String potentiel;
    private String dateConversion;
    private Integer probabilite;
    private String notesProspect;
}