package com.backend.yowyob.Repositories;

import com.backend.yowyob.entity.SpecialOpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecialOpeningHoursRepository extends JpaRepository<SpecialOpeningHours, UUID> {
}
