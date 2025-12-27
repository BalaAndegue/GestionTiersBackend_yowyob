package com.backend.yowyob.Repositories;

import com.backend.yowyob.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, UUID> {
    List<Agency> findByOrganizationId(UUID organizationId);
}
