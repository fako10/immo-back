package com.immobelgo.dto.mapper;

import com.immobelgo.dto.PrixDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Prix;

public class PrixMapper {

    public static Prix toEntity(PrixDto dto, Annonce annonce) {
        Prix entity = new Prix();
        entity.setAnnonce(annonce);
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setPrix(dto.getPrixVente());
        entity.setCharges(dto.getCharges());
        entity.setPrixMetreCarre(dto.getPrixMetreCarre());
        entity.setTva(dto.getTva());
        entity.setRevenuCadastre(dto.getRevenuCadastre());
        return entity;
    }

    public static PrixDto toDto(Prix entity, Annonce annonce) {
        PrixDto dto = new PrixDto();
        dto.setId(entity.getId());
        dto.setPrixVente(entity.getPrix());
        dto.setCharges(entity.getCharges());
        dto.setPrixMetreCarre(entity.getPrixMetreCarre());
        dto.setTva(entity.getTva());
        dto.setRevenuCadastre(entity.getRevenuCadastre());
        return dto;
    }
}


