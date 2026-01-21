package com.backend.yowyob.dtos;


import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TiersBaseDTO {
    @Schema(description = "Identifiant unique du tiers", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;

    @Schema(description = "Compte comptable OHADA (Généré automatiquement)", example = "411XYZ123", accessMode = Schema.AccessMode.READ_ONLY)
    private String compteComptable;

    @Schema(description = "Nom ou Raison sociale", requiredMode = Schema.RequiredMode.REQUIRED, example = "Entreprise XYZ")
    private String name;
    
    private String shortName;
    private String longName;
    private Boolean active;
    private String description;
    
    @Schema(description = "Adresse email de contact", example = "contact@entreprise.com")
    private String email;
    
    @Schema(description = "Numéro de téléphone", example = "+237699000000")
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