package com.backend.yowyob.Repositories;

import com.backend.yowyob.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    
    List<Tenant> findByNameContainingIgnoreCase(String name);
    
    boolean existsByEmail(String email); // Si vous ajoutez un champ email
    
    // Ajoutez d'autres méthodes de recherche si nécessaire
}