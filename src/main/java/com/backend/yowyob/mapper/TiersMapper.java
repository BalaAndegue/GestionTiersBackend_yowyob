package com.backend.yowyob.mapper;

import com.backend.yowyob.entity.*;
import com.backend.yowyob.dtos.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TiersMapper {
    
    TiersMapper INSTANCE = Mappers.getMapper(TiersMapper.class);
    
    // Mappings de base
    @Mapping(target = "tenantId", source = "tenant.id")
    @Mapping(target = "agencyId", source = "agency.id")
    TiersBaseDTO toBaseDTO(Tiers tiers);
    Tiers toBaseEntity(TiersBaseDTO dto);
    
    // Mappings Client
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Client toClientEntity(ClientDTO dto);
    
    ClientDTO toClientDTO(Client client);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDTO(ClientDTO dto, @MappingTarget Client client);
    
    // Mappings Fournisseur
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Fournisseur toFournisseurEntity(FournisseurDTO dto);
    
    FournisseurDTO toFournisseurDTO(Fournisseur fournisseur);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFournisseurFromDTO(FournisseurDTO dto, @MappingTarget Fournisseur fournisseur);
    
    // Mappings Commercial
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Commercial toCommercialEntity(CommercialDTO dto);
    
    CommercialDTO toCommercialDTO(Commercial commercial);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommercialFromDTO(CommercialDTO dto, @MappingTarget Commercial commercial);
    
    // Mappings Prospect
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Prospect toProspectEntity(ProspectDTO dto);
    
    ProspectDTO toProspectDTO(Prospect prospect);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProspectFromDTO(ProspectDTO dto, @MappingTarget Prospect prospect);
    
    // Méthodes de conversion pour les enums
    default String map(Tiers.Pays pays) {
        return pays != null ? pays.name() : null;
    }
    
    default Tiers.Pays mapPays(String pays) {
        return pays != null ? Tiers.Pays.valueOf(pays) : null;
    }
    
    default String map(Client.SegmentClient segment) {
        return segment != null ? segment.name() : null;
    }
    
    default Client.SegmentClient mapSegment(String segment) {
        return segment != null ? Client.SegmentClient.valueOf(segment) : null;
    }
    
    default String map(Commercial.TypeCommercial type) {
        return type != null ? type.name() : null;
    }
    
    default Commercial.TypeCommercial mapTypeCommercial(String type) {
        return type != null ? Commercial.TypeCommercial.valueOf(type) : null;
    }
    
    // Ajoutez les autres mappings d'enum nécessaires...
    default String map(Client.TypeClientOhada type) {
        return type != null ? type.name() : null;
    }

    default Client.TypeClientOhada mapTypeClientOhada(String type) {
        return type != null ? Client.TypeClientOhada.valueOf(type) : null;
    }

    default String map(Fournisseur.TypeFournisseurOhada type) {
        return type != null ? type.name() : null;
    }

    default Fournisseur.TypeFournisseurOhada mapTypeFournisseurOhada(String type) {
        return type != null ? Fournisseur.TypeFournisseurOhada.valueOf(type) : null;
    }

    default String map(Commercial.TypePersonnelOhada type) {
        return type != null ? type.name() : null;
    }

    default Commercial.TypePersonnelOhada mapTypePersonnelOhada(String type) {
        return type != null ? Commercial.TypePersonnelOhada.valueOf(type) : null;
    }

    default String map(Prospect.TypeProspectOhada type) {
        return type != null ? type.name() : null;
    }

    default Prospect.TypeProspectOhada mapTypeProspectOhada(String type) {
        return type != null ? Prospect.TypeProspectOhada.valueOf(type) : null;
    }
}