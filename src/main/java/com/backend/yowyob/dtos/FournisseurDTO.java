package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
public class FournisseurDTO extends TiersBaseDTO {
    private String modePaiement;
    private String delaiLivraison;
    private String produitsPrincipaux;
    private String certification;
}