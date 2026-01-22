package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.FournisseurDTO;
import com.backend.yowyob.dtos.ProspectDTO;
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
@RequestMapping("/api/prospects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Prospects", description = "API de gestion des prospects")
public class ProspectController {
    private final TiersService tiersService;
    
    @Operation(summary = "Créer un prospect", description = "Crée un nouveau prospect dans le système avec auto-génération du code comptable")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prospect créé avec succès",
                     content = @Content(schema = @Schema(implementation = ProspectDTO.class))),
        @ApiResponse(responseCode = "400", description = "Données invalides"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping
    public ResponseEntity<ProspectDTO> createProspect(
            @Parameter(description = "Données du prospect", required = true)
            @RequestBody ProspectDTO prospectDTO) {
        return ResponseEntity.ok(tiersService.createProspect(prospectDTO));
    }

    @Operation(summary = "Récupérer tous les prospects")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    })
    @GetMapping
    public ResponseEntity<List<ProspectDTO>> getAllProspects() {
        return ResponseEntity.ok(tiersService.findAllProspects());
    }

    @Operation(summary = "Récupérer un prospect par ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prospect trouvé"),
        @ApiResponse(responseCode = "404", description = "Prospect non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProspectDTO> getProspectById(
            @Parameter(description = "ID du prospect", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.findProspectById(id));
    }

    @Operation(summary = "Mettre à jour un prospect")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mise à jour réussie"),
        @ApiResponse(responseCode = "404", description = "Prospect non trouvé")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProspectDTO> updateProspect(
            @Parameter(description = "ID du prospect", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nouvelles données", required = true)
            @RequestBody ProspectDTO prospectDTO) {
        return ResponseEntity.ok(tiersService.updateProspect(id, prospectDTO));
    }

    @Operation(summary = "Supprimer un prospect")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Suppression réussie"),
        @ApiResponse(responseCode = "404", description = "Prospect non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProspect(
            @Parameter(description = "ID du prospect", required = true)
            @PathVariable UUID id) {
        tiersService.deleteTiers(id);
        return ResponseEntity.ok().build();
    }

     @Operation(summary = "Activer un prospect")
     @PutMapping("/{id}/activate")
    public ResponseEntity<ProspectDTO> activateProspect(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.activateProspect(id));
    }
    
    @Operation(summary = "Désactiver un prospect")
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ProspectDTO> deactivateProspect(@PathVariable UUID id) {
        return ResponseEntity.ok(tiersService.deactivateProspect(id));
    }

    @Operation(summary = "Récupérer les prospects actifs")
    @GetMapping("/active")
    public ResponseEntity<List<ProspectDTO>> getActiveProspects() {
        return ResponseEntity.ok(tiersService.findActiveProspects());
    }

    @Operation(summary = "Récupérer les prospects inactifs")
    @GetMapping("/inactive")
    public ResponseEntity<List<ProspectDTO>> getInactiveProspects() {
        return ResponseEntity.ok(tiersService.findInactiveProspects());
    }

    @Operation(summary = "Mettre à jour la qualification", description = "Met à jour le potentiel, la probabilité, la source et les notes")
    @PutMapping("/{id}/qualification")
    public ResponseEntity<ProspectDTO> updateQualification(
            @PathVariable UUID id,
            @RequestParam(required = false) com.backend.yowyob.entity.Prospect.Potentiel potentiel,
            @RequestParam(required = false) Integer probabilite,
            @RequestParam(required = false) com.backend.yowyob.entity.Prospect.SourceProspect sourceProspect,
            @RequestParam(required = false) String notesProspect) {
        return ResponseEntity.ok(tiersService.updateProspectQualification(id, potentiel, probabilite, sourceProspect, notesProspect));
    }

    @Operation(summary = "Mettre à jour la conversion", description = "Met à jour la date de conversion et le type OHADA")
    @PutMapping("/{id}/conversion")
    public ResponseEntity<ProspectDTO> updateConversion(
            @PathVariable UUID id,
            @RequestParam(required = false) java.time.LocalDate dateConversion,
            @RequestParam(required = false) com.backend.yowyob.entity.Prospect.TypeProspectOhada typeProspectOhada) {
        return ResponseEntity.ok(tiersService.updateProspectConversion(id, dateConversion, typeProspectOhada));
    }
}