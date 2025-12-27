package com.backend.yowyob.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class AgencyDTO {
    private UUID id;
    private UUID organizationId;
    private String code;
    private String name;
    private String location;
    private String description;
    private String timezone;
    private String address;
    private UUID ownerId;
    private UUID managerId;
    private Boolean transferable;
    private Boolean isActive;
    private String logoUrl;
    private UUID logoId;
    private String shortName;
    private String longName;
    private Boolean isIndividualBusiness;
    private Boolean isHeadquarter;
    private String country;
    private String city;
    private Double latitude;
    private Double longitude;
    private String openTime;
    private String closeTime;
    private String phone;
    private String email;
    private String whatsapp;
    private String greetingMessage;
    private BigDecimal averageRevenue;
    private BigDecimal capitalShare;
    private String registrationNumber;
    private String socialNetwork;
    private String taxNumber;
    private List<String> keywords;
    private Boolean isPublic;
    private Boolean isBusiness;
    private Integer totalAffiliatedCustomers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Nested Opening Hours
    private List<OpeningHoursRuleDTO> openingHoursRules;
    private List<SpecialOpeningHoursDTO> specialOpeningHours;
}
