package com.backend.yowyob.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OpeningHoursRuleDTO {
    private UUID id;
    private UUID organizationId;
    private UUID agencyId;
    private Integer dayOfWeek;
    private Boolean isClosed;
    private List<OpeningHoursIntervalDTO> intervals;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
