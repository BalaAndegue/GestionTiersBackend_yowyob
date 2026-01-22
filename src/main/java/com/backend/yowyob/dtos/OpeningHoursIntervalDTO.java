package com.backend.yowyob.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class OpeningHoursIntervalDTO {
    private UUID id;
    private UUID organizationId;
    private UUID ruleId;
    @Schema(type = "string", example = "08:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Schema(type = "string", example = "18:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
