package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.TiersBaseDTO;
import com.backend.yowyob.entity.Tiers;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tiers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Tiers", description = "API commune pour tous les types de tiers")
public class TiersController {
    
    private final TiersService tiersService;
    
    @Operation(summary = "Récupérer tous les tiers", description = "Retourne la liste de tous les types de tiers")
    @GetMapping
    public ResponseEntity<List<TiersBaseDTO>> getAllTiers() {
        return ResponseEntity.ok(tiersService.findAllTiers());
    }
    
    @Operation(summary = "Récupérer un tiers par ID", description = "Retourne un tiers spécifique par son ID")
    @GetMapping("/{id}")
    public ResponseEntity<TiersBaseDTO> getTiersById(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findTiersById(id));
    }

    @Operation(summary = "Récupérer les tiers par agence", description = "Retourne la liste des tiers liés à une agence")
    @GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<TiersBaseDTO>> getTiersByAgency(@PathVariable UUID agencyId) {
        return ResponseEntity.ok(tiersService.findTiersByAgency(agencyId));
    }
    
    @Operation(summary = "Supprimer un tiers", description = "Supprime un tiers du système")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTiers(@PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }

    // Activer un tiers
    @PutMapping("/{id}/activate")
    public ResponseEntity<Tiers> activateTiers(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateTiers(id));
    }
    
    // Désactiver un tiers
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Tiers> deactivateTiers(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateTiers(id));
    }
    
    // Récupérer seulement les tiers actifs
    @GetMapping("/active")
    public ResponseEntity<List<Tiers>> getActiveTiers() {
        return ResponseEntity.ok(tiersService.getAllActiveTiers());
    }
    
    // Récupérer seulement les tiers inactifs
    @GetMapping("/inactive")
    public ResponseEntity<List<Tiers>> getInactiveTiers() {
        return ResponseEntity.ok(tiersService.getAllInactiveTiers());
    }

    // Affecter un tiers à une agence
    @Operation(summary = "Affecter un tiers à une agence", description = "Associe un tiers à une agence spécifique. Vérifie si l'agence est ouverte.")
    @PutMapping("/{id}/assign-agency/{agencyId}")
    public ResponseEntity<Tiers> assignTierToAgency(@PathVariable UUID id, @PathVariable UUID agencyId) {
        return ResponseEntity.ok(tiersService.assignTierToAgency(id, agencyId));
    }
}