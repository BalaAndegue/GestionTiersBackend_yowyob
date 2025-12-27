package com.backend.yowyob.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class TenantDTO {
    private UUID id;
    private String code;
    private String service;
    private UUID businessActorId;
    private Boolean isIndividualBusiness;
    private String email;
    private String shortName;
    private String longName;
    private String description;
    private String logoUrl;
    private UUID logoId;
    private String websiteUrl;
    private String socialNetwork;
    private String businessRegistrationNumber;
    private String taxNumber;
    private BigDecimal capitalShare;
    private String ceoName;
    private Integer yearFounded;
    private List<String> keywords;
    private Integer numberOfEmployees;
    private String legalForm;
    private Boolean isActive;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}