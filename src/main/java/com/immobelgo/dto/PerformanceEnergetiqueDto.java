package com.immobelgo.dto;


import lombok.Data;

@Data
public class PerformanceEnergetiqueDto {

    private Long id;
    private Long idAnnonce;
    private String typeChauffage;
    private String classeEnergetique;
    private String numeroReferenceCPEB;
    private long consommationPEB;
    private long emissionPEB;
    private String descriptionPebNL;
    private String descriptionPebFR;
    private String descriptionPebEN;
    private Boolean conformiteELectrique;
    private Boolean conformiteMazout;
    private Boolean pompeChaleur;
    private Boolean panneauxSolaire;
    private Boolean panneauxPhotovoltaique;
    private Boolean doubleVitrage;
    private Boolean tripleVitrage;
    private Boolean chauffeEauCommun;
    private Boolean climatisation;
}
