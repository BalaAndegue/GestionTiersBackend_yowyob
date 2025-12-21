package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.CommercialDTO;
import com.backend.yowyob.dtos.FournisseurDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
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
    
    @Operation(summary = "Créer un commercial")
    @PostMapping
    public ResponseEntity<CommercialDTO> createCommercial(@RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.createCommercial(commercialDTO));
    }

    @Operation(summary = "Récupérer tous les commerciaux")
    @GetMapping
    public ResponseEntity<List<CommercialDTO>> getAllCommerciaux() {
        return ResponseEntity.ok(tiersService.findAllCommerciaux());
    }

    @Operation(summary = "Récupérer un commercial par ID")
    @GetMapping("/{id}")
    public ResponseEntity<CommercialDTO> getCommercialById(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findCommercialById(id));
    }

    @Operation(summary = "Mettre à jour un commercial")
    @PutMapping("/{id}")
    public ResponseEntity<CommercialDTO> updateCommercial(@PathVariable UUID id, @RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.updateCommercial(id, commercialDTO));
    }

    @Operation(summary = "Supprimer un commercial")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommercial(@PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }




     @PutMapping("/{id}/activate")
    public ResponseEntity<CommercialDTO> activateCommercial(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateCommercial(id));
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CommercialDTO> deactivateCommercial(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateCommercial(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<CommercialDTO>> getActiveCommerciaux() {
        return ResponseEntity.ok(tiersService.findActiveCommerciaux());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<CommercialDTO>> getInactiveCommerciaux() {
        return ResponseEntity.ok(tiersService.findInactiveCommerciaux());
    }
}