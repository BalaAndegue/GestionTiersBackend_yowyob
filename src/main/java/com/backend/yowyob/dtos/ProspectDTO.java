package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class ProspectDTO extends TiersBaseDTO {
    private String sourceProspect;
    private String potentiel;
    private String dateConversion;
    private Integer probabilite;
    private String notesProspect;
}