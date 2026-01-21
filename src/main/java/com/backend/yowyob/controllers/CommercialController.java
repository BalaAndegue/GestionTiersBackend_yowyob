package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.CommercialDTO;
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
@RequestMapping("/api/commerciaux")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Commerciaux", description = "API de gestion des commerciaux")
public class CommercialController {
    private final TiersService tiersService;
    
    @Operation(summary = "Créer un commercial", description = "Crée un nouveau commercial dans le système avec auto-génération du code comptable")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Commercial créé avec succès",
                     content = @Content(schema = @Schema(implementation = CommercialDTO.class))),
        @ApiResponse(responseCode = "400", description = "Données invalides"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping
    public ResponseEntity<CommercialDTO> createCommercial(
            @Parameter(description = "Données du commercial", required = true)
            @RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.createCommercial(commercialDTO));
    }

    @Operation(summary = "Récupérer tous les commerciaux")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<CommercialDTO>> getAllCommerciaux() {
        return ResponseEntity.ok(tiersService.findAllCommerciaux());
    }

    @Operation(summary = "Récupérer un commercial par ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Commercial trouvé"),
        @ApiResponse(responseCode = "404", description = "Commercial non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommercialDTO> getCommercialById(
            @Parameter(description = "ID du commercial", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findCommercialById(id));
    }

    @Operation(summary = "Mettre à jour un commercial")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mise à jour réussie"),
        @ApiResponse(responseCode = "404", description = "Commercial non trouvé")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CommercialDTO> updateCommercial(
            @Parameter(description = "ID du commercial", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nouvelles données", required = true)
            @RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.updateCommercial(id, commercialDTO));
    }

    @Operation(summary = "Supprimer un commercial")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Suppression réussie"),
        @ApiResponse(responseCode = "404", description = "Commercial non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommercial(
            @Parameter(description = "ID du commercial", required = true)
            @PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }




     @Operation(summary = "Activer un commercial")
     @PutMapping("/{id}/activate")
    public ResponseEntity<CommercialDTO> activateCommercial(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateCommercial(id));
    }
    
    @Operation(summary = "Désactiver un commercial")
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CommercialDTO> deactivateCommercial(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateCommercial(id));
    }

    @Operation(summary = "Récupérer les commerciaux actifs")
    @GetMapping("/active")
    public ResponseEntity<List<CommercialDTO>> getActiveCommerciaux() {
        return ResponseEntity.ok(tiersService.findActiveCommerciaux());
    }

    @Operation(summary = "Récupérer les commerciaux inactifs")
    @GetMapping("/inactive")
    public ResponseEntity<List<CommercialDTO>> getInactiveCommerciaux() {
        return ResponseEntity.ok(tiersService.findInactiveCommerciaux());
    }
}