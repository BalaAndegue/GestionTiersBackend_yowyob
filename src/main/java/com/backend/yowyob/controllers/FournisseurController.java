package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.FournisseurDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fournisseurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Fournisseurs", description = "API de gestion des fournisseurs")
public class FournisseurController {
    
    private final TiersService tiersService;

    @Operation(summary = "Créer un fournisseur", description = "Crée un nouveau fournisseur dans le système avec auto-génération du code comptable")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fournisseur créé avec succès",
                     content = @Content(schema = @Schema(implementation = FournisseurDTO.class))),
        @ApiResponse(responseCode = "400", description = "Données invalides"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping
    public ResponseEntity<FournisseurDTO> createFournisseur(
            @Parameter(description = "Données du fournisseur", required = true)
            @RequestBody FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(tiersService.createFournisseur(fournisseurDTO));
    }

    @Operation(summary = "Récupérer tous les fournisseurs")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> getAllFournisseurs() {
        return ResponseEntity.ok(tiersService.findAllFournisseurs());
    }

    @Operation(summary = "Récupérer un fournisseur par ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fournisseur trouvé"),
        @ApiResponse(responseCode = "404", description = "Fournisseur non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseurById(
            @Parameter(description = "ID du fournisseur", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findFournisseurById(id));
    }

    @Operation(summary = "Mettre à jour un fournisseur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mise à jour réussie"),
        @ApiResponse(responseCode = "404", description = "Fournisseur non trouvé")
    })
    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> updateFournisseur(
            @Parameter(description = "ID du fournisseur", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nouvelles données", required = true)
            @RequestBody FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(tiersService.updateFournisseur(id, fournisseurDTO));
    }

    @Operation(summary = "Supprimer un fournisseur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Suppression réussie"),
        @ApiResponse(responseCode = "404", description = "Fournisseur non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(
            @Parameter(description = "ID du fournisseur", required = true)
            @PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }

     @Operation(summary = "Activer un fournisseur")
     @PutMapping("/{id}/activate")
    public ResponseEntity<FournisseurDTO> activateFournisseur(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateFournisseur(id));
    }
    
    @Operation(summary = "Désactiver un fournisseur")
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<FournisseurDTO> deactivateFournisseur(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateFournisseur(id));
    }
    
    @Operation(summary = "Récupérer les fournisseurs actifs")
    @GetMapping("/active")
    public ResponseEntity<List<FournisseurDTO>> getActiveFournisseurs() {
        return ResponseEntity.ok(tiersService.findActiveFournisseurs());
    }

    @Operation(summary = "Récupérer les fournisseurs inactifs")
    @GetMapping("/inactive")
    public ResponseEntity<List<FournisseurDTO>> getInactiveFournisseurs() {
        return ResponseEntity.ok(tiersService.findInactiveFournisseurs());
    }

    @Operation(summary = "Mettre à jour les informations financières", description = "Met à jour le mode de paiement et le délai de livraison")
    @PutMapping("/{id}/financial-info")
    public ResponseEntity<FournisseurDTO> updateFinancialInfo(
            @PathVariable UUID id,
            @RequestParam(required = false) com.backend.yowyob.entity.Fournisseur.ModePaiement modePaiement,
            @RequestParam(required = false) String delaiLivraison) {
        return ResponseEntity.ok(tiersService.updateFournisseurFinancialInfo(id, modePaiement, delaiLivraison));
    }

    @Operation(summary = "Mettre à jour les informations métier", description = "Met à jour le type OHADA, les produits principaux et la certification")
    @PutMapping("/{id}/business-info")
    public ResponseEntity<FournisseurDTO> updateBusinessInfo(
            @PathVariable UUID id,
            @RequestParam(required = false) com.backend.yowyob.entity.Fournisseur.TypeFournisseurOhada typeFournisseurOhada,
            @RequestParam(required = false) com.backend.yowyob.entity.Fournisseur.ProduitPrincipal produitsPrincipaux,
            @RequestParam(required = false) String certification) {
        return ResponseEntity.ok(tiersService.updateFournisseurBusinessInfo(id, typeFournisseurOhada, produitsPrincipaux, certification));
    }
}