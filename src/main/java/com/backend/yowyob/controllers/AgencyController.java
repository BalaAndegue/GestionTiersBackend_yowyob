package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.AgencyDTO;
import com.backend.yowyob.services.AgencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agencies")
@RequiredArgsConstructor
@Tag(name = "Agencies", description = "API de gestion des agences")
@CrossOrigin(origins = "*")
public class AgencyController {

    private final AgencyService agencyService;

    @Operation(summary = "Créer une nouvelle agence")
    @PostMapping
    public ResponseEntity<AgencyDTO> createAgency(@RequestBody AgencyDTO agencyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agencyService.createAgency(agencyDTO));
    }

    @Operation(summary = "Récupérer une agence par ID")
    @GetMapping("/{id}")
    public ResponseEntity<AgencyDTO> getAgencyById(@PathVariable UUID id) {
        return ResponseEntity.ok(agencyService.getAgencyById(id));
    }

    @Operation(summary = "Récupérer les agences d'une organisation")
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<AgencyDTO>> getAgenciesByOrganization(@PathVariable UUID organizationId) {
        return ResponseEntity.ok(agencyService.getAgenciesByOrganization(organizationId));
    }

    @Operation(summary = "Mettre à jour une agence")
    @PutMapping("/{id}")
    public ResponseEntity<AgencyDTO> updateAgency(@PathVariable UUID id, @RequestBody AgencyDTO agencyDTO) {
        return ResponseEntity.ok(agencyService.updateAgency(id, agencyDTO));
    }

    @Operation(summary = "Supprimer une agence")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable UUID id) {
        agencyService.deleteAgency(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Vérifier si une agence est ouverte à une date donnée")
    @GetMapping("/{id}/is-open")
    public ResponseEntity<Boolean> isAgencyOpen(@PathVariable UUID id, @RequestParam(required = false) LocalDateTime dateTime) {
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
        return ResponseEntity.ok(agencyService.isAgencyOpen(id, dateTime));
    }
}
