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
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "agencies", ignore = true)
    Tenant toEntity(TenantDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "agencies", ignore = true)
    void updateEntityFromDTO(TenantDTO dto, @MappingTarget Tenant tenant);

}