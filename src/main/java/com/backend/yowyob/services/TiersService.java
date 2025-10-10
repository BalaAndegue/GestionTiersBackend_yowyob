package com.backend.yowyob.services;



import com.backend.yowyob.Repositories.*;
import com.backend.yowyob.entity.*;
import com.backend.yowyob.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface TiersService {
    // Méthodes communes
    List<TiersBaseDTO> findAllTiers();
    TiersBaseDTO findTiersById(Long id);
    void deleteTiers(Long id);
    
    // Clients
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    List<ClientDTO> findAllClients();
    ClientDTO findClientById(Long id);
    
    // Fournisseurs
    FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO);
    FournisseurDTO updateFournisseur(Long id, FournisseurDTO fournisseurDTO);
    List<FournisseurDTO> findAllFournisseurs();
    FournisseurDTO findFournisseurById(Long id);
    
    // Commerciaux
    CommercialDTO createCommercial(CommercialDTO commercialDTO);
    CommercialDTO updateCommercial(Long id, CommercialDTO commercialDTO);
    List<CommercialDTO> findAllCommerciaux();
    CommercialDTO findCommercialById(Long id);
    
    // Prospects
    ProspectDTO createProspect(ProspectDTO prospectDTO);
    ProspectDTO updateProspect(Long id, ProspectDTO prospectDTO);
    List<ProspectDTO> findAllProspects();
    ProspectDTO findProspectById(Long id);
}
