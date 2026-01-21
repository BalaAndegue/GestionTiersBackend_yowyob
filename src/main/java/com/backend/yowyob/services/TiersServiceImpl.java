package com.backend.yowyob.services;

import com.backend.yowyob.dtos.*;
import com.backend.yowyob.entity.*;
import com.backend.yowyob.mapper.TiersMapper;

import jakarta.persistence.EntityNotFoundException;

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
    private final AgencyService agencyService;
    private final AgencyRepository agencyRepository;
    
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
    public List<TiersBaseDTO> findTiersByAgency(UUID agencyId) {
        return tiersRepository.findByAgencyId(agencyId).stream()
                .map(tiersMapper::toBaseDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public void deleteTiers(UUID id) {
        tiersRepository.deleteById(id);
    }
    
    // === Clients ===
    
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = tiersMapper.toClientEntity(clientDTO);
        client.setCompteComptable(generateCompteComptable(client));
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
        fournisseur.setCompteComptable(generateCompteComptable(fournisseur));
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
        commercial.setCompteComptable(generateCompteComptable(commercial));
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
        prospect.setCompteComptable(generateCompteComptable(prospect));
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


    // Activer un tiers
    public Tiers activateTiers(UUID id) {
        Tiers tiers = tiersRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tiers non trouvé"));
            
        // Check Agency Opening Hours
        if (tiers.getAgency() != null) {
            checkAgencyOpen(tiers.getAgency().getId());
        }
            
        tiers.activate();
        return tiersRepository.save(tiers);
    }
    
    // Désactiver un tiers
    public Tiers deactivateTiers(UUID id) {
        Tiers tiers = tiersRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tiers non trouvé"));

        // Check Agency Opening Hours
        if (tiers.getAgency() != null) {
            checkAgencyOpen(tiers.getAgency().getId());
        }

        tiers.deactivate();
        return tiersRepository.save(tiers);
    }

    @Override
    public Tiers assignTierToAgency(UUID tierId, UUID agencyId) {
        Tiers tiers = tiersRepository.findById(tierId)
                .orElseThrow(() -> new EntityNotFoundException("Tiers non trouvé"));
        
        Agency agency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new EntityNotFoundException("Agence non trouvée"));
        
        // Check if target agency is open
        checkAgencyOpen(agencyId);
        
        tiers.setAgency(agency);
        return tiersRepository.save(tiers);
    }

    private void checkAgencyOpen(UUID agencyId) {
        if (!agencyService.isAgencyOpen(agencyId, java.time.LocalDateTime.now())) {
            throw new RuntimeException("Action non autorisée : L'agence est fermée actuellement.");
        }
    }

    private String generateCompteComptable(Tiers tier) {
        String prefix = "";
        if (tier instanceof Client) {
            prefix = "411";
        } else if (tier instanceof Fournisseur) {
            prefix = "401";
        } else if (tier instanceof Commercial) {
            prefix = "421";
        } else if (tier instanceof Prospect) {
            prefix = "411";
        } else {
            prefix = "471"; // Divers / Attente
        }
        
        // Utilisation du code unique du tiers comme suffixe
        // Si le code n'est pas encore généré par la logique métier, on pourrait utiliser une partie de l'UUID ou un timestamp
        // Mais ici 'code' semble être présent dans le DTO et mappé par MapStruct
        String suffix = tier.getCode() != null ? tier.getCode() : UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
        return prefix + suffix;
    }
    
    // Récupérer seulement les tiers actifs
    public List<Tiers> getAllActiveTiers() {
        return tiersRepository.findByActiveTrue();
    }
    
    // Récupérer seulement les tiers inactifs
    public List<Tiers> getAllInactiveTiers() {
        return tiersRepository.findByActiveFalse();
    }
    
    // Créer un tiers (actif par défaut)
    public Tiers createTiers(Tiers tiers) {
        tiers.setActive(true); // S'assurer qu'il est actif à la création
        return tiersRepository.save(tiers);
    }

    // Pour les Clients
    public ClientDTO activateClient(UUID id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Client non trouvé"));
            
        if (client.getAgency() != null) {
            checkAgencyOpen(client.getAgency().getId());
        }
        
        client.setActive(true);
        Client saved = clientRepository.save(client);
        return tiersMapper.toClientDTO(saved);
    }
    
    public ClientDTO deactivateClient(UUID id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Client non trouvé"));
            
        if (client.getAgency() != null) {
            checkAgencyOpen(client.getAgency().getId());
        }

        client.setActive(false);
        Client saved = clientRepository.save(client);
        return tiersMapper.toClientDTO(saved);
    }
    
    public List<ClientDTO> findActiveClients() {
        return clientRepository.findByActiveTrue().stream()
            .map(tiersMapper::toClientDTO)
            .collect(Collectors.toList());
    }

    public List<ClientDTO> findInactiveClients() {
        return clientRepository.findByActiveFalse().stream()
            .map(tiersMapper::toClientDTO)
            .collect(Collectors.toList());
    }

    // Pour les Fournisseurs
    public FournisseurDTO activateFournisseur(UUID id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Fournisseur non trouvé"));
            
        if (fournisseur.getAgency() != null) {
            checkAgencyOpen(fournisseur.getAgency().getId());
        }

        fournisseur.setActive(true);
        Fournisseur saved = fournisseurRepository.save(fournisseur);
        return tiersMapper.toFournisseurDTO(saved);
    }
    
    public FournisseurDTO deactivateFournisseur(UUID id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Fournisseur non trouvé"));

        if (fournisseur.getAgency() != null) {
            checkAgencyOpen(fournisseur.getAgency().getId());
        }

        fournisseur.setActive(false);
        Fournisseur saved = fournisseurRepository.save(fournisseur);
        return tiersMapper.toFournisseurDTO(saved);
    }
    
    public List<FournisseurDTO> findActiveFournisseurs() {
        return fournisseurRepository.findByActiveTrue().stream()
            .map(tiersMapper::toFournisseurDTO)
            .collect(Collectors.toList());
    }

    public List<FournisseurDTO> findInactiveFournisseurs() {
        return fournisseurRepository.findByActiveFalse().stream()
            .map(tiersMapper::toFournisseurDTO)
            .collect(Collectors.toList());
    }

    // Pour les Commerciaux
    public CommercialDTO activateCommercial(UUID id) {
        Commercial commercial = commercialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commercial non trouvé"));

        if (commercial.getAgency() != null) {
            checkAgencyOpen(commercial.getAgency().getId());
        }

        commercial.setActive(true);
        Commercial saved = commercialRepository.save(commercial);
        return tiersMapper.toCommercialDTO(saved);
    }
    
    public CommercialDTO deactivateCommercial(UUID id) {
        Commercial commercial = commercialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commercial non trouvé"));

        if (commercial.getAgency() != null) {
            checkAgencyOpen(commercial.getAgency().getId());
        }

        commercial.setActive(false);
        Commercial saved = commercialRepository.save(commercial);
        return tiersMapper.toCommercialDTO(saved);
    }
    
    public List<CommercialDTO> findActiveCommerciaux() {
        return commercialRepository.findByActiveTrue().stream()
            .map(tiersMapper::toCommercialDTO)
            .collect(Collectors.toList());
    }

    public List<CommercialDTO> findInactiveCommerciaux() {
        return commercialRepository.findByActiveFalse().stream()
            .map(tiersMapper::toCommercialDTO)
            .collect(Collectors.toList());
    }

    // Pour les Prospects
    public ProspectDTO activateProspect(UUID id) {
        Prospect prospect = prospectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Prospect non trouvé"));

        if (prospect.getAgency() != null) {
            checkAgencyOpen(prospect.getAgency().getId());
        }

        prospect.setActive(true);
        Prospect saved = prospectRepository.save(prospect);
        return tiersMapper.toProspectDTO(saved);
    }
    
    public ProspectDTO deactivateProspect(UUID id) {
        Prospect prospect = prospectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Prospect non trouvé"));

        if (prospect.getAgency() != null) {
            checkAgencyOpen(prospect.getAgency().getId());
        }

        prospect.setActive(false);
        Prospect saved = prospectRepository.save(prospect);
        return tiersMapper.toProspectDTO(saved);
    }
    
    public List<ProspectDTO> findActiveProspects() {
        return prospectRepository.findByActiveTrue().stream()
            .map(tiersMapper::toProspectDTO)
            .collect(Collectors.toList());
    }

    public List<ProspectDTO> findInactiveProspects() {
        return prospectRepository.findByActiveFalse().stream()
            .map(tiersMapper::toProspectDTO)
            .collect(Collectors.toList());
    }
}