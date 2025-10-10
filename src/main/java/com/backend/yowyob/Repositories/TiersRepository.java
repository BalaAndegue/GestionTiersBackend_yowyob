package com.backend.yowyob.Repositories;


import com.backend.yowyob.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long> {
    List<Tiers> findByNameContainingIgnoreCase(String name);
    List<Tiers> findByTypeEntreprise(Tiers.TypeEntreprise typeEntreprise);
}
