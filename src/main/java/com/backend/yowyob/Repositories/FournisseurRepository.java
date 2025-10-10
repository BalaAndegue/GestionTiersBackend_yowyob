package com.backend.yowyob.Repositories;


import com.backend.yowyob.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findByModePaiement(Fournisseur.ModePaiement modePaiement);
}
