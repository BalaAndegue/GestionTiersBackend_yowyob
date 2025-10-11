package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.CommercialDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<CommercialDTO> getCommercialById(@PathVariable Long id) {
        return ResponseEntity.ok(tiersService.findCommercialById(id));
    }

    @Operation(summary = "Mettre à jour un commercial")
    @PutMapping("/{id}")
    public ResponseEntity<CommercialDTO> updateCommercial(@PathVariable Long id, @RequestBody CommercialDTO commercialDTO) {
        return ResponseEntity.ok(tiersService.updateCommercial(id, commercialDTO));
    }

    @Operation(summary = "Supprimer un commercial")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommercial(@PathVariable Long id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
}