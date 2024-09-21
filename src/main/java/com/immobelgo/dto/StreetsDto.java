package com.immobelgo.dto;

import lombok.Data;



@Data
public class StreetsDto {

    private long streetId;
    private long municipalityId;
    private String municipalityNameDe;
    private String municipalityNameFr;
    private String municipalityNameNl;
    private String postCode;
    private String postNameFr;
    private String postNameNl;
    private String streetNameDe;
    private String streetNameFr;
    private String streetNameNl;
    private String regionCode;

}
