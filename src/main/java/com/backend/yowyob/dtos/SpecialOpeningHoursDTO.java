package com.backend.yowyob.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Boolean isClosed;
    private String label;
    private List<SpecialOpeningHoursIntervalDTO> intervals;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
