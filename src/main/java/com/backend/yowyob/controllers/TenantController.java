package com.backend.yowyob.controllers;

import com.backend.yowyob.dtos.TenantDTO;
import com.backend.yowyob.services.TenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
@Tag(name = "Tenants", description = "API de gestion des tenants (locataires/organisations)")
@CrossOrigin(origins = "*") // Pour le développement, à restreindre en production
public class TenantController {
    
    private final TenantService tenantService;
    
    @Operation(summary = "Créer un nouveau tenant")
    @PostMapping
    public ResponseEntity<TenantDTO> createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantDTO createdTenant = tenantService.createTenant(tenantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTenant);
    }
    
    @Operation(summary = "Récupérer tous les tenants")
    @GetMapping
    public ResponseEntity<List<TenantDTO>> getAllTenants() {
        List<TenantDTO> tenants = tenantService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }
    
    @Operation(summary = "Récupérer un tenant par son ID")
    @GetMapping("/{id}")
    public ResponseEntity<TenantDTO> getTenantById(@PathVariable UUID id) {
        TenantDTO tenant = tenantService.getTenantById(id);
        return ResponseEntity.ok(tenant);
    }
    
    @Operation(summary = "Mettre à jour un tenant")
    @PutMapping("/{id}")
    public ResponseEntity<TenantDTO> updateTenant(
            @PathVariable UUID id,
            @RequestBody TenantDTO tenantDTO) {
        TenantDTO updatedTenant = tenantService.updateTenant(id, tenantDTO);
        return ResponseEntity.ok(updatedTenant);
    }
    
    @Operation(summary = "Supprimer un tenant")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable UUID id) {
        tenantService.deleteTenant(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Rechercher des tenants par nom")
    @GetMapping("/search")
    public ResponseEntity<List<TenantDTO>> searchTenantsByName(
            @RequestParam String name) {
        List<TenantDTO> tenants = tenantService.searchTenantsByName(name);
        return ResponseEntity.ok(tenants);
    }
}