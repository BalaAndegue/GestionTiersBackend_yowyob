package com.backend.yowyob.Repositories;


import com.backend.yowyob.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProspectRepository extends JpaRepository<Prospect, Long> {
    List<Prospect> findByPotentiel(Prospect.Potentiel potentiel);
    
    @Query("SELECT p FROM Prospect p WHERE p.probabilite > :minProbabilite")
    List<Prospect> findByProbabiliteGreaterThan(Integer minProbabilite);
}