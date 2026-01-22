package com.backend.yowyob.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Schema(description = "Code unique du tiers (Généré si absent)", example = "T0123456")
    private String code;

    @Schema(description = "Nom ou Raison sociale", requiredMode = Schema.RequiredMode.REQUIRED, example = "Entreprise XYZ")
    private String name;
    
    @Schema(description = "Nom court ou abréviation", example = "XYZ")
    private String shortName;
    
    @Schema(description = "Nom complet ou raison sociale étendue", example = "Entreprise XYZ SA")
    private String longName;
    
    @Schema(description = "Statut d'activation du tiers", example = "true")
    private Boolean active;
    
    @Schema(description = "Description détaillée ou notes", example = "Client important secteur technologique")
    private String description;
    
    @Schema(description = "Adresse email de contact", example = "contact@entreprise.com")
    private String email;
    
    @Schema(description = "Numéro de téléphone", example = "+237699000000")
    private String phoneNumber;
    
    @Schema(description = "Site web officiel", example = "https://www.xyz.com")
    private String website;
    
    @Schema(description = "Adresse physique", example = "123 Rue de la République")
    private String address;
    
    @Schema(description = "Complément d'adresse", example = "Etage 2, Porte 4")
    private String complement;
    
    @Schema(description = "Code postal", example = "92000")
    private String postalCode;
    
    @Schema(description = "Ville", example = "Douala")
    private String city;
    
    @Schema(description = "Pays", example = "CMR")
    private String pays;
    
    @Schema(description = "Secteur d'activité", example = "IT")
    private String secteurActivite;
    
    @Schema(description = "Taille de l'entreprise", example = "PME")
    private String tailleEntreprise;
    
    @Schema(description = "Date de création de l'entreprise", example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;
    
    @Schema(description = "Numéro du registre de commerce", example = "RC/DLA/2020/B/123")
    private String registreCommerce;
    
    @Schema(description = "Numéro d'identifiant fiscal", example = "M012000000000L")
    private String numeroFiscal;
    
    @Schema(description = "Canal de communication préféré", example = "EMAIL", allowableValues = {"EMAIL", "TELEPHONE", "SMS", "WHATSAPP"})
    private String canalPrefere;
    
    @Schema(description = "Forme juridique", example = "SA", allowableValues = {"SA", "SARL", "SAS", "Ets"})
    private String typeEntreprise;
    
    @Schema(description = "ID du locataire (multi-tenant)", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID tenantId;
    
    @Schema(description = "ID de l'agence de rattachement", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID agencyId;
}