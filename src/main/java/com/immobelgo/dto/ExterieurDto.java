package com.immobelgo.dto;

import lombok.Data;

@Data
public class ExterieurDto {

    private Long            id;
    private Long            idAnnonce;
    private Boolean         jardin;
    private long            superficieJardin;
    private long            superficieTerrain;
    private Boolean         piscine;
    private long            superficiePiscine;
    private Boolean         terrasse;
    private Long            superficieTerrasse;
    private Boolean         vueSurMer;

}
