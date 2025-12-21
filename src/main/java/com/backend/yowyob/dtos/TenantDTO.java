package com.backend.yowyob.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TenantDTO {
    private UUID id;
    private String name;
    private String website;
    
    // Adresse
    private String address;
    private String complement;
    private String postalCode;
    private String city;
    private String pays;
    
    // Informations entreprise
    private String secteurActivite;
    private String tailleEntreprise;
    private LocalDate dateCreation;
    private String registreCommerce;
    private String numeroFiscal;
    private String enterpriseName;
    
    // Canal préféré
    private String canalPrefere;
    private String typeEntreprise;
    
    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}