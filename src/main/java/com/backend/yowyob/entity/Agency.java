package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import java.util.ArrayList;

@Entity
@Table(name = "agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizationId", nullable = false)
    private Tenant organization;

    private String code;
    private String name;
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String timezone;
    private String address;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "manager_id")
    private UUID managerId;

    private Boolean transferable;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "logo_id")
    private UUID logoId;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "long_name")
    private String longName;

    @Column(name = "is_individual_business")
    private Boolean isIndividualBusiness;

    @Column(name = "is_headquarter")
    private Boolean isHeadquarter;

    private String country;
    private String city;
    private Double latitude;
    private Double longitude;

    @Column(name = "open_time")
    private String openTime;

    @Column(name = "close_time")
    private String closeTime;

    private String phone;
    private String email;
    private String whatsapp;

    @Column(name = "greeting_message", columnDefinition = "TEXT")
    private String greetingMessage;

    @Column(name = "average_revenue")
    private BigDecimal averageRevenue;

    @Column(name = "capital_share")
    private BigDecimal capitalShare;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "social_network")
    private String socialNetwork;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "keywords", columnDefinition = "text[]")
    private List<String> keywords;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "is_business")
    private Boolean isBusiness;

    @Column(name = "total_affiliated_customers")
    private Integer totalAffiliatedCustomers;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OpeningHoursRule> openingHoursRules = new ArrayList<>();

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpecialOpeningHours> specialOpeningHours = new ArrayList<>();

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    public UUID getId() {
        return id;
    }

    public List<OpeningHoursRule> getOpeningHoursRules() {
        return openingHoursRules;
    }

    public List<SpecialOpeningHours> getSpecialOpeningHours() {
        return specialOpeningHours;
    }

    public void setOpeningHoursRules(List<OpeningHoursRule> openingHoursRules) {
        this.openingHoursRules = openingHoursRules;
    }

    public void setSpecialOpeningHours(List<SpecialOpeningHours> specialOpeningHours) {
        this.specialOpeningHours = specialOpeningHours;
    }
}
