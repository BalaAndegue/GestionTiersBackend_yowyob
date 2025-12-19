package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.ProspectDTO;
import com.backend.yowyob.services.TiersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prospects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Prospects", description = "API de gestion des prospects")
public class ProspectController {
    private final TiersService tiersService;
    
    @Operation(summary = "Créer un prospect")
    @PostMapping
    public ResponseEntity<ProspectDTO> createProspect(@RequestBody ProspectDTO prospectDTO) {
        return ResponseEntity.ok(tiersService.createProspect(prospectDTO));
    }

    @Operation(summary = "Récupérer tous les prospects")
    @GetMapping
    public ResponseEntity<List<ProspectDTO>> getAllProspects() {
        return ResponseEntity.ok(tiersService.findAllProspects());
    }

    @Operation(summary = "Récupérer un prospect par ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProspectDTO> getProspectById(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findProspectById(id));
    }

    @Operation(summary = "Mettre à jour un prospect")
    @PutMapping("/{id}")
    public ResponseEntity<ProspectDTO> updateProspect(@PathVariable UUID id, @RequestBody ProspectDTO prospectDTO) {
        return ResponseEntity.ok(tiersService.updateProspect(id, prospectDTO));
    }

    @Operation(summary = "Supprimer un prospect")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProspect(@PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }
}