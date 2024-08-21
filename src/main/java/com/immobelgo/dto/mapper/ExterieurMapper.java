package com.immobelgo.dto.mapper;

import com.immobelgo.dto.ExterieurDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Exterieur;

public class ExterieurMapper {

    public static Exterieur toEntity(ExterieurDto dto, Annonce annonce) {
        Exterieur entity = new Exterieur();
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setAnnonce(annonce);
        entity.setJardin(dto.getJardin());
        entity.setSuperficieJardin(dto.getSuperficieJardin());
        entity.setPiscine(dto.getPiscine());
        entity.setSuperficiePiscine(dto.getSuperficiePiscine());
        entity.setTerrasse(dto.getTerrasse());
        entity.setSuperficieTerrasse(dto.getSuperficieTerrasse());
        entity.setVueSurMer(dto.getVueSurMer());
        return entity;
    }

    public static ExterieurDto toDto(Exterieur entity) {
        ExterieurDto dto = new ExterieurDto();
        dto.setJardin(entity.getJardin());
        dto.setSuperficieJardin(entity.getSuperficieJardin());
        dto.setPiscine(entity.getPiscine());
        dto.setSuperficiePiscine(entity.getSuperficiePiscine());
        dto.setTerrasse(entity.getTerrasse());
        dto.setSuperficieTerrasse(entity.getSuperficieTerrasse());
        dto.setVueSurMer(entity.getVueSurMer());
        return dto;
    }

}
