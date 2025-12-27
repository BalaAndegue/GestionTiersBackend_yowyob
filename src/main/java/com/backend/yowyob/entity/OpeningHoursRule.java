package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "opening_hours_rule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpeningHoursRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizationId", nullable = false)
    private Tenant organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agencyId", nullable = false)
    private Agency agency;

    private Integer dayOfWeek;

    private Boolean isClosed;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OpeningHoursInterval> intervals = new ArrayList<>();

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

    public List<OpeningHoursInterval> getIntervals() {
        return intervals;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void setIntervals(List<OpeningHoursInterval> intervals) {
        this.intervals = intervals;
    }
}
