package com.backend.yowyob.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
