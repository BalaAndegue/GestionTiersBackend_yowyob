package com.backend.yowyob.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class SpecialOpeningHoursIntervalDTO {
    private UUID id;
    private UUID organizationId;
    private UUID specialId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
