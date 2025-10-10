package com.backend.yowyob.dtos;


import lombok.Data;
import java.time.LocalDate;

@Data
public class TiersBaseDTO {
    private Long id;
    private String name;
    private String shortName;
    private String longName;
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
}