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
}
