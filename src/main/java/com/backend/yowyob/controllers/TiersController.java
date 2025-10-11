package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.TiersBaseDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<TiersBaseDTO> getTiersById(@PathVariable Long id) {
        return ResponseEntity.ok(tiersService.findTiersById(id));
    }
    
    @Operation(summary = "Supprimer un tiers", description = "Supprime un tiers du système")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTiers(@PathVariable Long id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
}