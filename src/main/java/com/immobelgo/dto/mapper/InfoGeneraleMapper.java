package com.immobelgo.dto.mapper;

import com.immobelgo.dto.AnnonceDto;
import com.immobelgo.dto.InfoGeneraleDto;
import com.immobelgo.dto.InfobaseDto;
import com.immobelgo.entities.Annonce;

public class InfoGeneraleMapper {

    public static InfoGeneraleDto toDto(Annonce annonce) {
        InfoGeneraleDto dto = new InfoGeneraleDto();
        dto.setNombreFacade(annonce.getNbrFacade());
        dto.setLargeurFacade(annonce.getLargeurFacade());
        dto.setSurfaceTerrain(annonce.getSurfaceTerrain());
        dto.setSurfaceHabitable(annonce.getSurfaceHabitable());
        dto.setNombreEtage(annonce.getNbrEtage());
        dto.setAnneeConstruction(annonce.getAnneeConstruction());
        if(annonce.getEtatBatiment() != null) {
            dto.setEtatBatiment(annonce.getEtatBatiment().name());
        }
        dto.setParking(annonce.getParking());
        dto.setNombrePlaceParking(annonce.getNbrPlaceParking());
        dto.setAscenseur(annonce.getAscenseur());
        dto.setAccesHandicape(annonce.getAccesHandicape());
        return dto;
    }

}
