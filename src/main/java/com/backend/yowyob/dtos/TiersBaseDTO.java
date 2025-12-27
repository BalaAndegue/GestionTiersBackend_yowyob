package com.backend.yowyob.dtos;


import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TiersBaseDTO {
    private UUID id;
    private String name;
    private String shortName;
    private String longName;
    private Boolean active;
    private String description;
    private String email;
    private String phoneNumber;
    private String website;
    private String address;
    private String complement;
    private String postalCode;
    private String city;
    private String pays;
    private String secteurActivite;
    private String tailleEntreprise;
    private LocalDate dateCreation;
    private String registreCommerce;
    private String numeroFiscal;
    private String canalPrefere;
    private String typeEntreprise;
    private UUID tenantId;
    private UUID agencyId;
}