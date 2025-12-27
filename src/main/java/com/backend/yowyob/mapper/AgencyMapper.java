package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.Agency;
import com.backend.yowyob.dtos.AgencyDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OpeningHoursMapper.class, SpecialOpeningHoursMapper.class})
public interface AgencyMapper {
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "openingHoursRules", source = "openingHoursRules")
    @Mapping(target = "specialOpeningHours", source = "specialOpeningHours")
    AgencyDTO toDTO(Agency agency);
    
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    Agency toEntity(AgencyDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntityFromDTO(AgencyDTO dto, @MappingTarget Agency agency);
}
