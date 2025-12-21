package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.Tenant;
import com.backend.yowyob.dtos.TenantDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    
    TenantDTO toDTO(Tenant tenant);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "tousLesTiers", ignore = true)
    Tenant toEntity(TenantDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "tousLesTiers", ignore = true)
    void updateEntityFromDTO(TenantDTO dto, @MappingTarget Tenant tenant);
    
    // Conversion d'enums
    default String map(Tenant.Pays pays) {
        return pays != null ? pays.name() : null;
    }
    
    default Tenant.Pays mapPays(String pays) {
        return pays != null ? Tenant.Pays.valueOf(pays) : null;
    }
    
    default String map(Tenant.SecteurActivite secteur) {
        return secteur != null ? secteur.name() : null;
    }
    
    default Tenant.SecteurActivite mapSecteur(String secteur) {
        return secteur != null ? Tenant.SecteurActivite.valueOf(secteur) : null;
    }
    
    // ... autres mappings d'enum
}