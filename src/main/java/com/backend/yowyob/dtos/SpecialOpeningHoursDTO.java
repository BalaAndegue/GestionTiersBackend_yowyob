package com.backend.yowyob.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class SpecialOpeningHoursDTO {
    private UUID id;
    private UUID organizationId;
    private UUID agencyId;
    private LocalDate date;
    private Boolean isClosed;
    private String label;
    private List<SpecialOpeningHoursIntervalDTO> intervals;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
