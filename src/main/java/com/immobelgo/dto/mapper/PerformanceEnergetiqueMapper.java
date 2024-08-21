package com.immobelgo.dto.mapper;


import com.immobelgo.dto.PerformanceEnergetiqueDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.PerformanceEnergetique;
import com.immobelgo.entities.enume.ClasseEnergetique;
import com.immobelgo.entities.enume.Typechauffage;


public class PerformanceEnergetiqueMapper {

    public static PerformanceEnergetique toEntity(PerformanceEnergetiqueDto dto, Annonce annonce) {
        PerformanceEnergetique entity = new PerformanceEnergetique();
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setClasseEnergetique(ClasseEnergetique.fromString(dto.getClasseEnergetique()));
        entity.setClimatisation(dto.getClimatisation());
        entity.setAnnonce(annonce);
        entity.setNumeroReferenceCPEB(dto.getNumeroReferenceCPEB());
        entity.setConsommationPEB(dto.getConsommationPEB());
        entity.setEmissionPEB(dto.getEmissionPEB());
        entity.setDescriptionPebNL(dto.getDescriptionPebNL());
        entity.setDescriptionPebFR(dto.getDescriptionPebFR());
        entity.setConformiteELectrique(dto.getConformiteELectrique());
        entity.setConformiteMazout(dto.getConformiteMazout());
        entity.setPompeChaleur(dto.getPompeChaleur());
        entity.setPanneauxSolaire(dto.getPanneauxSolaire());
        entity.setPanneauxPhotovoltaique(dto.getPanneauxPhotovoltaique());
        entity.setDoubleVitrage(dto.getDoubleVitrage());
        entity.setTripleVitrage(dto.getTripleVitrage());
        entity.setChauffeEauCommun(dto.getChauffeEauCommun());
        entity.setClimatisation(dto.getClimatisation());
        if(dto.getTypeChauffage() != null) {
            entity.setTypeChauffage(Typechauffage.fromString(dto.getTypeChauffage()));
        }

        return entity;
    }

    public static PerformanceEnergetiqueDto toDto(PerformanceEnergetique entity) {
        PerformanceEnergetiqueDto dto = new PerformanceEnergetiqueDto();
        if(entity != null) {
            dto.setId(entity.getId());
            if(entity.getClasseEnergetique() != null) {
                dto.setClasseEnergetique(entity.getClasseEnergetique().libelle);
            }
            dto.setClimatisation(dto.getClimatisation());
            dto.setNumeroReferenceCPEB(dto.getNumeroReferenceCPEB());
            dto.setConsommationPEB(dto.getConsommationPEB());
            dto.setEmissionPEB(dto.getEmissionPEB());
            dto.setDescriptionPebNL(dto.getDescriptionPebNL());
            dto.setDescriptionPebFR(dto.getDescriptionPebFR());
            dto.setConformiteELectrique(dto.getConformiteELectrique());
            dto.setConformiteMazout(dto.getConformiteMazout());
            dto.setPompeChaleur(dto.getPompeChaleur());
            dto.setPanneauxSolaire(dto.getPanneauxSolaire());
            dto.setPanneauxPhotovoltaique(dto.getPanneauxPhotovoltaique());
            dto.setDoubleVitrage(dto.getDoubleVitrage());
            dto.setTripleVitrage(dto.getTripleVitrage());
            dto.setChauffeEauCommun(dto.getChauffeEauCommun());
            dto.setClimatisation(dto.getClimatisation());
        }

        //type chauffage à gérer
        // entity.setTypeChauffage(TypeChauffage.);
        return dto;

    }


}
