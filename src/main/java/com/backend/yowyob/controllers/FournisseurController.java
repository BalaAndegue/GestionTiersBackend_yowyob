package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.FournisseurDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Fournisseurs", description = "API de gestion des fournisseurs")
public class FournisseurController {
    
    private final TiersService tiersService;

    @Operation(summary = "Créer un fournisseur")
    @PostMapping
    public ResponseEntity<FournisseurDTO> createFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(tiersService.createFournisseur(fournisseurDTO));
    }

    @Operation(summary = "Récupérer tous les fournisseurs")
    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> getAllFournisseurs() {
        return ResponseEntity.ok(tiersService.findAllFournisseurs());
    }

    @Operation(summary = "Récupérer un fournisseur par ID")
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseurById(@PathVariable Long id) {
        return ResponseEntity.ok(tiersService.findFournisseurById(id));
    }

    @Operation(summary = "Mettre à jour un fournisseur")
    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> updateFournisseur(@PathVariable Long id, @RequestBody FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(tiersService.updateFournisseur(id, fournisseurDTO));
    }

    @Operation(summary = "Supprimer un fournisseur")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
}