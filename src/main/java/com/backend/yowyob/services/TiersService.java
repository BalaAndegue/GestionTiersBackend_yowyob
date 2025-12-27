package com.backend.yowyob.services;



import com.backend.yowyob.Repositories.*;
import com.backend.yowyob.entity.*;
import com.backend.yowyob.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface TiersService {
    // Méthodes communes
    List<TiersBaseDTO> findAllTiers();
    TiersBaseDTO findTiersById(UUID id);
    List<TiersBaseDTO> findTiersByAgency(UUID agencyId);
    void deleteTiers(UUID id);
    
    // Clients
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(UUID id, ClientDTO clientDTO);
    List<ClientDTO> findAllClients();
    ClientDTO findClientById(UUID id);
    
    // Fournisseurs
    FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO);
    FournisseurDTO updateFournisseur(UUID id, FournisseurDTO fournisseurDTO);
    List<FournisseurDTO> findAllFournisseurs();
    FournisseurDTO findFournisseurById(UUID id);
    
    // Commerciaux
    CommercialDTO createCommercial(CommercialDTO commercialDTO);
    CommercialDTO updateCommercial(UUID id, CommercialDTO commercialDTO);
    List<CommercialDTO> findAllCommerciaux();
    CommercialDTO findCommercialById(UUID id);
    
    // Prospects
    ProspectDTO createProspect(ProspectDTO prospectDTO);
    ProspectDTO updateProspect(UUID id, ProspectDTO prospectDTO);
    List<ProspectDTO> findAllProspects();
    ProspectDTO findProspectById(UUID id);



    Tiers activateTiers(UUID id);
    Tiers deactivateTiers(UUID id);
    Tiers assignTierToAgency(UUID tierId, UUID agencyId);
    
    // Récupération par statut
    List<Tiers> getAllActiveTiers();
    List<Tiers> getAllInactiveTiers();
    
    // Création avec statut
    Tiers createTiers(Tiers tiers);

    // Spécifiques par type
    ClientDTO activateClient(UUID id);
    ClientDTO deactivateClient(UUID id);
    List<ClientDTO> findActiveClients();
    List<ClientDTO> findInactiveClients();

    FournisseurDTO activateFournisseur(UUID id);
    FournisseurDTO deactivateFournisseur(UUID id);
    List<FournisseurDTO> findActiveFournisseurs();
    List<FournisseurDTO> findInactiveFournisseurs();

    CommercialDTO activateCommercial(UUID id);
    CommercialDTO deactivateCommercial(UUID id);
    List<CommercialDTO> findActiveCommerciaux();
    List<CommercialDTO> findInactiveCommerciaux();

    ProspectDTO activateProspect(UUID id);
    ProspectDTO deactivateProspect(UUID id);
    List<ProspectDTO> findActiveProspects();
    List<ProspectDTO> findInactiveProspects();

}
