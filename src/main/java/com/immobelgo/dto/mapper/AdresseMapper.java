package com.immobelgo.dto.mapper;

import com.immobelgo.dto.AdresseDto;
import com.immobelgo.entities.Adresse;

public class AdresseMapper {

    public static AdresseDto toDto(Adresse adresse) {
        AdresseDto dto = new AdresseDto();
        if(adresse != null) {
            dto.setRueFr(adresse.getRueFr());
            dto.setCodePostal(adresse.getCodepostal());
            dto.setNumero(adresse.getNumeromaison().toString());
            if(adresse.getNumeroboite() != null) {
                dto.setBoite(adresse.getNumeroboite().toString());
            }
            dto.setCommuneFr(adresse.getNomcommunefr());
            dto.setCommuneNl(adresse.getNomcommunenl());
            dto.setRueNl(adresse.getRueNl());
            dto.setVilleFr(adresse.getNomvillefr());
            dto.setVilleNl(adresse.getNomvillenl());
        }

        return dto;
    }
}
