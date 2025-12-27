package com.backend.yowyob.services;

import com.backend.yowyob.dtos.AgencyDTO;
import com.backend.yowyob.entity.Agency;
import com.backend.yowyob.entity.OpeningHoursRule;
import com.backend.yowyob.entity.SpecialOpeningHours;
import com.backend.yowyob.mapper.AgencyMapper;
import com.backend.yowyob.Repositories.AgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AgencyService {

    private final AgencyRepository agencyRepository;
    private final AgencyMapper agencyMapper;

    public AgencyDTO createAgency(AgencyDTO dto) {
        Agency agency = agencyMapper.toEntity(dto);
        // Ensure bidirectional relationship if not handled by mapper or setter
        if (agency.getOpeningHoursRules() != null) {
            agency.getOpeningHoursRules().forEach(rule -> rule.setAgency(agency));
        }
        if (agency.getSpecialOpeningHours() != null) {
            agency.getSpecialOpeningHours().forEach(special -> special.setAgency(agency));
        }
        
        Agency saved = agencyRepository.save(agency);
        return agencyMapper.toDTO(saved);
    }

    public AgencyDTO getAgencyById(UUID id) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id: " + id));
        return agencyMapper.toDTO(agency);
    }

    public List<AgencyDTO> getAgenciesByOrganization(UUID organizationId) {
        return agencyRepository.findByOrganizationId(organizationId).stream()
                .map(agencyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AgencyDTO updateAgency(UUID id, AgencyDTO dto) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id: " + id));
        agencyMapper.updateEntityFromDTO(dto, agency);
        
        // Re-establish relationships if list was replaced (basic handling)
        if (agency.getOpeningHoursRules() != null) {
            agency.getOpeningHoursRules().forEach(rule -> rule.setAgency(agency));
        }
        
        Agency saved = agencyRepository.save(agency);
        return agencyMapper.toDTO(saved);
    }

    public void deleteAgency(UUID id) {
        agencyRepository.deleteById(id);
    }
    
    // Check if agency is open at a specific time
    public boolean isAgencyOpen(UUID agencyId, LocalDateTime dateTime) {
        Agency agency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new RuntimeException("Agency not found"));
        
        java.time.LocalDate date = dateTime.toLocalDate();
        java.time.LocalTime time = dateTime.toLocalTime();

        // 1. Check Special Opening Hours (Exceptions)
        SpecialOpeningHours special = agency.getSpecialOpeningHours().stream()
                .filter(s -> s.getDate().isEqual(date))
                .findFirst().orElse(null);
        
        if (special != null) {
             if (Boolean.TRUE.equals(special.getIsClosed())) return false;
             
             // Check intervals for special day
             // If no intervals defined but not closed, assume open all day? or closed?
             // Usually if intervals list is empty, it might mean logic is not fully defined, but let's assume if explicit intervals exist, we check them.
             if (special.getIntervals() != null && !special.getIntervals().isEmpty()) {
                 return special.getIntervals().stream()
                         .anyMatch(interval -> !time.isBefore(interval.getStartTime()) && !time.isAfter(interval.getEndTime()));
             }
             return true; // Open all day if no intervals restricted? Or should be default closed? Let's assume Open.
        }
        
        // 2. Check Regular Rules
        // DayOfWeek: 1 (Monday) to 7 (Sunday)
        int dayOfWeek = dateTime.getDayOfWeek().getValue(); 
        
        OpeningHoursRule rule = agency.getOpeningHoursRules().stream()
                .filter(r -> r.getDayOfWeek() == dayOfWeek)
                .findFirst().orElse(null);
        
        if (rule == null) {
            return false; // No rule for this day -> Closed by default? or Open? Usually Closed.
        }
        
        if (Boolean.TRUE.equals(rule.getIsClosed())) {
            return false;
        }
        
        if (rule.getIntervals() != null && !rule.getIntervals().isEmpty()) {
             return rule.getIntervals().stream()
                     .anyMatch(interval -> !time.isBefore(interval.getStartTime()) && !time.isAfter(interval.getEndTime()));
        }

        return true; // Open if rule exists and not closed and no specific intervals (?)
    }
}
