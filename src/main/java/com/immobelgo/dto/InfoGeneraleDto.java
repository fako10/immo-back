package com.immobelgo.dto;

import lombok.Data;

@Data
public class InfoGeneraleDto {

    private Integer nombreFacade;
    private Long largeurFacade;
    private Long surfaceTerrain;
    private Long surfaceHabitable;
    private Integer nombreEtage;
    private String anneeConstruction;
    private String etatBatiment;
    private Boolean parking;
    private Integer nombrePlaceParking;
    private Boolean ascenseur;
    private Boolean accesHandicape;

}
