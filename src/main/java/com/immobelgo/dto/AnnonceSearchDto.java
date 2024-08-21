package com.immobelgo.dto;

import lombok.Data;

@Data
public class AnnonceSearchDto {

    private Long id;
    private String typeTransaction;
    private String communeOuCodePostal;
    private Long prixMin;
    private Long prixMax;
    private String typeHabitation;
    private String sousTypeHabitation;
    private Long surfaceMinTerrain;
    private Long surfaceMaxTerrain;
    private Long surfaceMinHabitable;
    private Long surfaceMaxHabitable;
    private Long nbrMinChambre;
    private Long nbrMaxChambre;
    private Boolean accessibleHandicape;
    private Long anneeConstruction;
    private String classeEnergetique;


}
