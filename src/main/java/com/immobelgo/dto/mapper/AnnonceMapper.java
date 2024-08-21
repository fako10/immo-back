package com.immobelgo.dto.mapper;

import com.immobelgo.dto.AnnonceDto;
import com.immobelgo.dto.AnnonceLight;
import com.immobelgo.dto.AnnonceLightDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.enume.EtatBatimentEnum;
import com.immobelgo.helper.FileManagement;

public class AnnonceMapper {

    public static Annonce toEntity(AnnonceDto annonceDto) {
        Annonce annonce = new Annonce();
        annonce.setCodeAnnonce(annonceDto.getCodeAnnonce());

        if(annonceDto.getPrix() != null) {
            annonce.setPrix(annonceDto.getPrix().getPrixVente());
        }
        if(annonceDto.getInfoGenerale() != null) {
            annonce.setNbrFacade(annonceDto.getInfoGenerale().getNombreFacade());
            annonce.setLargeurFacade(annonceDto.getInfoGenerale().getLargeurFacade());
            annonce.setSurfaceHabitable(annonceDto.getInfoGenerale().getSurfaceHabitable());
            annonce.setNbrEtage(annonceDto.getInfoGenerale().getNombreEtage());
            annonce.setAnneeConstruction(annonceDto.getInfoGenerale().getAnneeConstruction());
            if(annonceDto.getInfoGenerale().getEtatBatiment() != null) {
                annonce.setEtatBatiment(EtatBatimentEnum.fromString( annonceDto.getInfoGenerale().getEtatBatiment()));
            }

            annonce.setAscenseur(annonceDto.getInfoGenerale().getAscenseur());
            annonce.setAccesHandicape(annonceDto.getInfoGenerale().getAccesHandicape());
            annonce.setParking(annonceDto.getInfoGenerale().getParking());
            annonce.setNbrPlaceParking(annonceDto.getInfoGenerale().getNombrePlaceParking());
        }
        if(annonceDto.getAdresse() != null) {
            annonce.setCodePostal(annonceDto.getAdresse().getCodePostal());
            annonce.setCommune(annonceDto.getAdresse().getCommuneFr());
        }
        if(annonceDto.getInfoBase() != null) {
            annonce.setDisponibilite(annonceDto.getInfoBase().getDisponibilite());
            if(annonceDto.getInfoBase().getTypeTransaction() != null) {
                annonce.setTypeTransaction(annonceDto.getInfoBase().getTypeTransaction());
                annonce.setTypeTransaction(annonceDto.getInfoBase().getTypeTransaction());
            }
        }
        if(annonceDto.getInterieur() != null) {
            annonce.setNbrChambre(annonceDto.getInterieur().getNbrChambre());
        }

        return annonce;
    }

    public static Annonce toEntity(AnnonceLightDto dto) {
        Annonce annonce = new Annonce();
        annonce.setNbrFacade(dto.getNbrFacade());
        annonce.setLargeurFacade(dto.getLargeurFacade());
        annonce.setSurfaceHabitable(dto.getSurfaceHabitable());
        annonce.setSurfaceTerrain(dto.getSurfaceTerrain());
        annonce.setNbrChambre(dto.getNbrChambre());
        annonce.setNbrEtage(dto.getNbrEtage());
        annonce.setAnneeConstruction(dto.getAnneeConstruction());
        annonce.setEtatBatiment(dto.getEtatBatiment());
        annonce.setAscenseur(dto.getAscenseur());
        annonce.setAccesHandicape(dto.getAccesHandicape());
        annonce.setCodeAnnonce(dto.getCodeAnnonce());
        annonce.setMeuble(dto.getMeuble());
        annonce.setGardien(dto.getGardien());

        annonce.setParking(dto.getParking());
        annonce.setNbrPlaceParking(dto.getNbrPlaceParking());

        annonce.setConcierge(dto.getConcierge());
        annonce.setDisponibilite(dto.getDisponibilite());

        annonce.setTitreFr(dto.getTitreFr());
        annonce.setTitreNl(dto.getTitreNl());
        annonce.setDescriptionFr(dto.getDescriptionFr());
        annonce.setDescriptionNl(dto.getDescriptionNl());

        annonce.setTypeTransaction(dto.getTypeTransaction());
        annonce.setCodePostal(dto.getCodePostal());
        annonce.setPrix(dto.getPrix());
        annonce.setCommune(dto.getCommune());
        return annonce;
    }

    public static AnnonceLightDto toDto(Annonce entity) {
        AnnonceLightDto dto = new AnnonceLightDto();
        dto.setNbrFacade(entity.getNbrFacade());
        dto.setLargeurFacade(entity.getLargeurFacade());
        dto.setSurfaceHabitable(entity.getSurfaceHabitable());
        dto.setSurfaceTerrain(entity.getSurfaceTerrain());
        dto.setNbrChambre(entity.getNbrChambre());
        dto.setNbrEtage(entity.getNbrEtage());
        dto.setAnneeConstruction(entity.getAnneeConstruction());
        dto.setEtatBatiment(entity.getEtatBatiment());
        dto.setAscenseur(entity.getAscenseur());
        dto.setAccesHandicape(entity.getAccesHandicape());
        dto.setMeuble(entity.getMeuble());
        dto.setGardien(entity.getGardien());
        dto.setNbrPlaceParking(entity.getNbrPlaceParking());
        dto.setConcierge(entity.getConcierge());
        dto.setDisponibilite(entity.getDisponibilite());
        dto.setTitreFr(entity.getTitreFr());
        dto.setTitreNl(entity.getTitreNl());
        dto.setDescriptionFr(entity.getDescriptionFr());
        dto.setDescriptionNl(entity.getDescriptionNl());
        //dto.setTypeTransaction(entity.getTypeTransaction());
        dto.setCodePostal(entity.getCodePostal());
        dto.setPrix(entity.getPrix());
        dto.setCommune(entity.getCommune());
        dto.setCodeAnnonce(entity.getCodeAnnonce());
        dto.setDateCreation(entity.getDateCreation());
        return dto;
    }

    public static AnnonceLight toDtoLight(Annonce entity) {
        AnnonceLight dto = new AnnonceLight();
        dto.setNbrChambre(entity.getNbrChambre());
        dto.setTitreFr(entity.getTitreFr());
        dto.setTitreNl(entity.getTitreNl());
        dto.setDescriptionFr(entity.getDescriptionFr());
        dto.setDescriptionNl(entity.getDescriptionNl());
        dto.setTypeTransaction(entity.getTypeTransaction());
        dto.setCodePostal(entity.getCodePostal());
        dto.setPrix(entity.getPrix());
        dto.setCommune(entity.getCommune());
        dto.setCodeAnnonce(entity.getCodeAnnonce());
        dto.setDateCreation(entity.getDateCreation());
        dto.setPhoto(FileManagement.decompressBytes(entity.getPhotoPresentation()));
        return dto;
    }

}



