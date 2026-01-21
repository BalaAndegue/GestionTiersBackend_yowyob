package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.ClientDTO;
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
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Clients", description = "API de gestion des clients")
public class ClientController {
    
    private final TiersService tiersService;

    @Operation(summary = "Créer un client", description = "Crée un nouveau client dans le système")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client créé avec succès",
                     content = @Content(schema = @Schema(implementation = ClientDTO.class))),
        @ApiResponse(responseCode = "400", description = "Données invalides"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(
            @Parameter(description = "Données du client à créer", required = true)
            @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(tiersService.createClient(clientDTO));
    }

    @Operation(summary = "Récupérer tous les clients", description = "Retourne la liste de tous les clients")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste des clients récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(tiersService.findAllClients());
    }

    @Operation(summary = "Récupérer un client par ID", description = "Retourne un client spécifique par son ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client trouvé"),
        @ApiResponse(responseCode = "404", description = "Client non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(
            @Parameter(description = "ID du client", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findClientById(id));
    }

    @Operation(summary = "Mettre à jour un client", description = "Met à jour les informations d'un client existant")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client mis à jour avec succès"),
        @ApiResponse(responseCode = "404", description = "Client non trouvé")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(
            @Parameter(description = "ID du client", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nouvelles données du client", required = true)
            @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(tiersService.updateClient(id, clientDTO));
    }

    @Operation(summary = "Supprimer un client", description = "Supprime un client du système")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client supprimé avec succès"),
        @ApiResponse(responseCode = "404", description = "Client non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(
            @Parameter(description = "ID du client à supprimer", required = true)
            @PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
     // Activer un client
    @PutMapping("/{id}/activate")
    public ResponseEntity<ClientDTO> activateClient(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateClient(id));
    }
    
    // Désactiver un client
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ClientDTO> deactivateClient(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateClient(id));
    }
    
    // Récupérer seulement les clients actifs
    @GetMapping("/active")
    public ResponseEntity<List<ClientDTO>> getActiveClients() {
        return ResponseEntity.ok(tiersService.findActiveClients());
    }

    // Récupérer seulement les clients inactifs
    @GetMapping("/inactive")
    public ResponseEntity<List<ClientDTO>> getInactiveClients() {
        return ResponseEntity.ok(tiersService.findInactiveClients());
    }

    @Operation(summary = "Mettre à jour les canaux de vente", description = "Active ou désactive les canaux de vente (Détail, Demi-Gros, Gros, Super-Gros)")
    @PutMapping("/{id}/sales-channels")
    public ResponseEntity<ClientDTO> updateSalesChannels(
            @PathVariable UUID id,
            @RequestParam(required = false) Boolean venteDetail,
            @RequestParam(required = false) Boolean venteDemiGros,
            @RequestParam(required = false) Boolean venteGros,
            @RequestParam(required = false) Boolean venteSuperGros) {
        return ResponseEntity.ok(tiersService.updateClientSalesChannels(id, venteDetail, venteDemiGros, venteGros, venteSuperGros));
    }

    @Operation(summary = "Mettre à jour le statut TVA", description = "Défini si le client est assujetti à la TVA")
    @PutMapping("/{id}/tva")
    public ResponseEntity<ClientDTO> updateTvaStatus(
            @PathVariable UUID id,
            @RequestParam Boolean assujetti) {
        return ResponseEntity.ok(tiersService.updateClientTvaStatus(id, assujetti));
    }
}