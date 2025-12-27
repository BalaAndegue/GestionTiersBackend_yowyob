package com.backend.yowyob.services;

import com.backend.yowyob.dtos.TenantDTO;
import com.backend.yowyob.entity.Tenant;
import com.backend.yowyob.mapper.TenantMapper;
import com.backend.yowyob.Repositories.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TenantService {
    
    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;
    
    // CREATE
    public TenantDTO createTenant(TenantDTO tenantDTO) {
        Tenant tenant = tenantMapper.toEntity(tenantDTO);
        Tenant savedTenant = tenantRepository.save(tenant);
        return tenantMapper.toDTO(savedTenant);
    }
    
    // READ ALL
    public List<TenantDTO> getAllTenants() {
        return tenantRepository.findAll()
                .stream()
                .map(tenantMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    // READ BY ID
    public TenantDTO getTenantById(UUID id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant non trouvé avec l'id: " + id));
        return tenantMapper.toDTO(tenant);
    }
    
    // UPDATE
    public TenantDTO updateTenant(UUID id, TenantDTO tenantDTO) {
        Tenant existingTenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant non trouvé avec l'id: " + id));
        
        tenantMapper.updateEntityFromDTO(tenantDTO, existingTenant);
        Tenant updatedTenant = tenantRepository.save(existingTenant);
        
        return tenantMapper.toDTO(updatedTenant);
    }
    
    // DELETE
    public void deleteTenant(UUID id) {
        if (!tenantRepository.existsById(id)) {
            throw new RuntimeException("Tenant non trouvé avec l'id: " + id);
        }
        tenantRepository.deleteById(id);
    }
    
    // Recherche par nom
    public List<TenantDTO> searchTenantsByName(String name) {
        return tenantRepository.findByShortNameContainingIgnoreCase(name)
                .stream()
                .map(tenantMapper::toDTO)
                .collect(Collectors.toList());
    }
}