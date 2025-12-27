package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tenant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;
    private String service;

    @Column(name = "business_actor_id")
    private UUID businessActorId;

    @Column(name = "is_individual_business")
    private Boolean isIndividualBusiness;

    @Column(unique = true)
    private String email;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "long_name")
    private String longName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "logo_id")
    private UUID logoId;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "social_network")
    private String socialNetwork;

    @Column(name = "business_registration_number")
    private String businessRegistrationNumber;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "capital_share")
    private BigDecimal capitalShare;

    @Column(name = "ceo_name")
    private String ceoName;

    @Column(name = "year_founded")
    private Integer yearFounded;

    @Column(name = "keywords", columnDefinition = "text[]")
    private List<String> keywords;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "legal_form")
    private String legalForm;

    @Column(name = "is_active")
    private Boolean isActive;

    private String status;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agency> agencies = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
