package com.backend.yowyob.services;

import com.backend.yowyob.dtos.*;
import com.backend.yowyob.entity.*;
import com.backend.yowyob.mapper.TiersMapper;
import com.backend.yowyob.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TiersServiceImpl implements TiersService {
    
    private final TiersRepository tiersRepository;
    private final ClientRepository clientRepository;
    private final FournisseurRepository fournisseurRepository;
    private final CommercialRepository commercialRepository;
    private final ProspectRepository prospectRepository;
    private final TiersMapper tiersMapper;
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // === Méthodes communes ===
    
    @Override
    public List<TiersBaseDTO> findAllTiers() {
        return tiersRepository.findAll().stream()
                .map(tiersMapper::toBaseDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public TiersBaseDTO findTiersById(UUID id) {
        Tiers tiers = tiersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tiers non trouvé avec l'id: " + id));
        return tiersMapper.toBaseDTO(tiers);
    }
    
    @Override
    public void deleteTiers(UUID id) {
        tiersRepository.deleteById(id);
    }
    
    // === Clients ===
    
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = tiersMapper.toClientEntity(clientDTO);
        Client saved = clientRepository.save(client);
        return tiersMapper.toClientDTO(saved);
    }
    
    @Override
    public ClientDTO updateClient(UUID id, ClientDTO clientDTO) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id: " + id));
        
        // Recréer l'entité au lieu de mettre à jour
        Client updatedClient = tiersMapper.toClientEntity(clientDTO);
        updatedClient.setId(existing.getId());
        updatedClient.setCreatedAt(existing.getCreatedAt());
        
        Client saved = clientRepository.save(updatedClient);
        return tiersMapper.toClientDTO(saved);
    }
    
    @Override
    public List<ClientDTO> findAllClients() {
        return clientRepository.findAll().stream()
                .map(tiersMapper::toClientDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ClientDTO findClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id: " + id));
        return tiersMapper.toClientDTO(client);
    }
    
    // === Fournisseurs ===
    
    @Override
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = tiersMapper.toFournisseurEntity(fournisseurDTO);
        Fournisseur saved = fournisseurRepository.save(fournisseur);
        return tiersMapper.toFournisseurDTO(saved);
    }
    
    @Override
    public FournisseurDTO updateFournisseur(UUID id, FournisseurDTO fournisseurDTO) {
        Fournisseur existing = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'id: " + id));
        
        // Recréer l'entité au lieu de mettre à jour
        Fournisseur updatedFournisseur = tiersMapper.toFournisseurEntity(fournisseurDTO);
        updatedFournisseur.setId(existing.getId());
        updatedFournisseur.setCreatedAt(existing.getCreatedAt());
        
        Fournisseur saved = fournisseurRepository.save(updatedFournisseur);
        return tiersMapper.toFournisseurDTO(saved);
    }
    
    @Override
    public List<FournisseurDTO> findAllFournisseurs() {
        return fournisseurRepository.findAll().stream()
                .map(tiersMapper::toFournisseurDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public FournisseurDTO findFournisseurById(UUID id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'id: " + id));
        return tiersMapper.toFournisseurDTO(fournisseur);
    }
    
    // === Commerciaux ===
    
    @Override
    public CommercialDTO createCommercial(CommercialDTO commercialDTO) {
        Commercial commercial = tiersMapper.toCommercialEntity(commercialDTO);
        Commercial saved = commercialRepository.save(commercial);
        return tiersMapper.toCommercialDTO(saved);
    }
    
    @Override
    public CommercialDTO updateCommercial(UUID id, CommercialDTO commercialDTO) {
        Commercial existing = commercialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commercial non trouvé avec l'id: " + id));
        
        // Recréer l'entité au lieu de mettre à jour
        Commercial updatedCommercial = tiersMapper.toCommercialEntity(commercialDTO);
        updatedCommercial.setId(existing.getId());
        updatedCommercial.setCreatedAt(existing.getCreatedAt());
        
        Commercial saved = commercialRepository.save(updatedCommercial);
        return tiersMapper.toCommercialDTO(saved);
    }
    
    @Override
    public List<CommercialDTO> findAllCommerciaux() {
        return commercialRepository.findAll().stream()
                .map(tiersMapper::toCommercialDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CommercialDTO findCommercialById(UUID id) {
        Commercial commercial = commercialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commercial non trouvé avec l'id: " + id));
        return tiersMapper.toCommercialDTO(commercial);
    }
    
    // === Prospects ===
    
    @Override
    public ProspectDTO createProspect(ProspectDTO prospectDTO) {
        Prospect prospect = tiersMapper.toProspectEntity(prospectDTO);
        Prospect saved = prospectRepository.save(prospect);
        return tiersMapper.toProspectDTO(saved);
    }
    
    @Override
    public ProspectDTO updateProspect(UUID id, ProspectDTO prospectDTO) {
        Prospect existing = prospectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospect non trouvé avec l'id: " + id));
        
        // Recréer l'entité au lieu de mettre à jour
        Prospect updatedProspect = tiersMapper.toProspectEntity(prospectDTO);
        updatedProspect.setId(existing.getId());
        updatedProspect.setCreatedAt(existing.getCreatedAt());
        
        Prospect saved = prospectRepository.save(updatedProspect);
        return tiersMapper.toProspectDTO(saved);
    }
    
    @Override
    public List<ProspectDTO> findAllProspects() {
        return prospectRepository.findAll().stream()
                .map(tiersMapper::toProspectDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ProspectDTO findProspectById(UUID id) {
        Prospect prospect = prospectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospect non trouvé avec l'id: " + id));
        return tiersMapper.toProspectDTO(prospect);
    }
}