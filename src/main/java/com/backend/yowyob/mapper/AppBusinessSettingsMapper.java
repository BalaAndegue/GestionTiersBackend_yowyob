package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.AppBusinessSettings;
import com.backend.yowyob.dtos.AppBusinessSettingsDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AppBusinessSettingsMapper {
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "orgAgencyId", source = "agency.id")
    AppBusinessSettingsDTO toDTO(AppBusinessSettings settings);
    
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "agency", ignore = true)
    AppBusinessSettings toEntity(AppBusinessSettingsDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "agency", ignore = true)
    void updateEntityFromDTO(AppBusinessSettingsDTO dto, @MappingTarget AppBusinessSettings settings);
}
