package com.immobelgo.dto.mapper;

import com.immobelgo.dto.TitreEtDescription;
import com.immobelgo.entities.Annonce;

public class TitreEtDescriptionMapper {

    public static TitreEtDescription toDto(Annonce annonce) {
        TitreEtDescription dto = new TitreEtDescription();
        dto.setTitreFr(annonce.getTitreFr());
        dto.setTitreNl(annonce.getTitreNl());
        dto.setDescriptionFr(annonce.getDescriptionFr());
        dto.setDescriptionNl(annonce.getDescriptionNl());
        return dto;
    }
}
