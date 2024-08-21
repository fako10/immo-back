package com.immobelgo.dto.mapper;

import com.immobelgo.dto.InfobaseDto;
import com.immobelgo.entities.Annonce;

public class InfoBaseMapper {

    public static InfobaseDto toDto(Annonce annonce) {
        InfobaseDto dto = new InfobaseDto();
        dto.setTypeTransaction(annonce.getTypeTransaction());
        //dto.setTypeTransaction(annonce.getTypeTransaction().name());
        dto.setDisponibilite(annonce.getDisponibilite());
        dto.setSousTypeBien(annonce.getSousTypeBien());
        dto.setTypeBien(annonce.getTypeBien());
        return dto;
    }
}
