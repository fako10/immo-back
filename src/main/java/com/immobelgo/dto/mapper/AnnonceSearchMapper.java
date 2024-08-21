package com.immobelgo.dto.mapper;

import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.entities.AnnonceSearch;

public class AnnonceSearchMapper {

    public static AnnonceSearchDto toDto(AnnonceSearch entity) {
        AnnonceSearchDto dto = new AnnonceSearchDto();
        dto.setId(entity.getId());
        dto.setTypeTransaction(entity.getTypeTransaction());
        dto.setCommuneOuCodePostal(entity.getCommuneOuCodePostal());
        dto.setPrixMin(entity.getPrixMin());
        dto.setPrixMax(entity.getPrixMax());
        dto.setTypeHabitation(entity.getTypeHabitation());
        dto.setSousTypeHabitation(entity.getSousTypeHabitation());
        dto.setSurfaceMinTerrain(entity.getSurfaceMinTerrain());
        dto.setSurfaceMaxTerrain(entity.getSurfaceMaxTerrain());
        dto.setSurfaceMinHabitable(entity.getSurfaceMinHabitable());
        dto.setSurfaceMaxHabitable(entity.getSurfaceMaxHabitable());
        dto.setNbrMinChambre(entity.getNbrMinChambre());
        dto.setNbrMaxChambre(entity.getNbrMaxChambre());
        dto.setAccessibleHandicape(entity.getAccessibleHandicape());
        dto.setAnneeConstruction(entity.getAnneeConstruction());
        dto.setClasseEnergetique(entity.getClasseEnergetique());
        return dto;
    }

    public static AnnonceSearch toEntity(AnnonceSearchDto dto) {
        AnnonceSearch entity = new AnnonceSearch();
        entity.setId(dto.getId());
        entity.setTypeTransaction(dto.getTypeTransaction());
        entity.setCommuneOuCodePostal(dto.getCommuneOuCodePostal());
        entity.setPrixMin(dto.getPrixMin());
        entity.setPrixMax(dto.getPrixMax());
        entity.setTypeHabitation(dto.getTypeHabitation());
        entity.setSousTypeHabitation(dto.getSousTypeHabitation());
        entity.setSurfaceMinTerrain(dto.getSurfaceMinTerrain());
        entity.setSurfaceMaxTerrain(dto.getSurfaceMaxTerrain());
        entity.setSurfaceMinHabitable(dto.getSurfaceMinHabitable());
        entity.setSurfaceMaxHabitable(dto.getSurfaceMaxHabitable());
        entity.setNbrMinChambre(dto.getNbrMinChambre());
        entity.setNbrMaxChambre(dto.getNbrMaxChambre());
        entity.setAccessibleHandicape(dto.getAccessibleHandicape());
        entity.setAnneeConstruction(dto.getAnneeConstruction());
        entity.setClasseEnergetique(dto.getClasseEnergetique());
        return entity;
    }
}
