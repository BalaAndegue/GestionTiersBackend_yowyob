package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class CommercialDTO extends TiersBaseDTO {
    private String typeCommercial;
    private BigDecimal commission;
    private String dateDebutContrat;
    private String dateFinContrat;
    private String zonesCouvertes;
    private String specialisations;
}

