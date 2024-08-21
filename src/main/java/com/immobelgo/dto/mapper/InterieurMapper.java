package com.immobelgo.dto.mapper;

import com.immobelgo.dto.InfoGeneraleDto;
import com.immobelgo.dto.InterieurDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Interieur;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class InterieurMapper {

    public static Interieur toEntity(InterieurDto dto, Annonce annonce) {
        Interieur entity = new Interieur();
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setAnnonce(annonce);
        entity.setNbrChambre(dto.getNbrChambre());
        entity.setNbrPiece(dto.getNbrPiece());
        entity.setNbrToilette(dto.getNbrToilette());
        entity.setNbrSalleBain(dto.getNbrSalleBain());
        return entity;
    }

    public static InterieurDto toDto(Interieur entity) {
        InterieurDto dto = new InterieurDto();

        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }


        dto.setNbrChambre(entity.getNbrChambre());
        dto.setNbrPiece(entity.getNbrPiece());
        dto.setNbrToilette(entity.getNbrToilette());
        dto.setNbrSalleBain(entity.getNbrSalleBain());
        return dto;
    }
}

