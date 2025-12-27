package com.backend.yowyob.Repositories;

import com.backend.yowyob.entity.AppBusinessSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppBusinessSettingsRepository extends JpaRepository<AppBusinessSettings, String> {
}
