package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "special_opening_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialOpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizationId", nullable = false)
    private Tenant organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agencyId", nullable = false)
    private Agency agency;

    private LocalDate date;

    private Boolean isClosed;

    private String label;

    @OneToMany(mappedBy = "specialOpeningHours", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpecialOpeningHoursInterval> intervals = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    public Boolean getIsClosed() {
        return isClosed;
    }

    public List<SpecialOpeningHoursInterval> getIntervals() {
        return intervals;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void setIntervals(List<SpecialOpeningHoursInterval> intervals) {
        this.intervals = intervals;
    }
}
