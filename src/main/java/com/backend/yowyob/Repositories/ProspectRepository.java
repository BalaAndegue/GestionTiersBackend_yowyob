package com.backend.yowyob.Repositories;


// Ajouter l'import manquant en haut de TiersMapper.java
import com.backend.yowyob.entity.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProspectRepository extends JpaRepository<Prospect, UUID> {
    List<Prospect> findByPotentiel(Prospect.Potentiel potentiel);
    
    @Query("SELECT p FROM Prospect p WHERE p.probabilite > :minProbabilite")
    List<Prospect> findByProbabiliteGreaterThan(Integer minProbabilite);
}