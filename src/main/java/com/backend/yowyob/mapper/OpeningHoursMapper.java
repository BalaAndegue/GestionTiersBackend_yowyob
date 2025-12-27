package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.OpeningHoursRule;
import com.backend.yowyob.entity.OpeningHoursInterval;
import com.backend.yowyob.dtos.OpeningHoursRuleDTO;
import com.backend.yowyob.dtos.OpeningHoursIntervalDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OpeningHoursMapper {
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "agencyId", source = "agency.id")
    OpeningHoursRuleDTO toDTO(OpeningHoursRule rule);
    
    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "ruleId", source = "rule.id")
    OpeningHoursIntervalDTO toDTO(OpeningHoursInterval interval);

    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "agency", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    OpeningHoursRule toEntity(OpeningHoursRuleDTO dto);
    
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "rule", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    OpeningHoursInterval toEntity(OpeningHoursIntervalDTO dto);
}
