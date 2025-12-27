package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.SpecialOpeningHours;
import com.backend.yowyob.entity.SpecialOpeningHoursInterval;
import com.backend.yowyob.dtos.SpecialOpeningHoursDTO;
import com.backend.yowyob.dtos.SpecialOpeningHoursIntervalDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SpecialOpeningHoursMapper {
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "agencyId", source = "agency.id")
    SpecialOpeningHoursDTO toDTO(SpecialOpeningHours special);
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "specialId", source = "specialOpeningHours.id")
    SpecialOpeningHoursIntervalDTO toDTO(SpecialOpeningHoursInterval interval);

    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "agency", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    SpecialOpeningHours toEntity(SpecialOpeningHoursDTO dto);
    
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "specialOpeningHours", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    SpecialOpeningHoursInterval toEntity(SpecialOpeningHoursIntervalDTO dto);
}
