package com.backend.yowyob.Repositories;

import com.backend.yowyob.entity.OpeningHoursRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OpeningHoursRuleRepository extends JpaRepository<OpeningHoursRule, UUID> {
}
