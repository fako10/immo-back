package com.immobelgo.dto;

import lombok.Data;


@Data
public class MunicipalityDto implements Comparable<MunicipalityDto> {

    private long municipalityId;
    private String municipalityNameDe;
    private String municipalityNameFr;
    private String municipalityNameNl;
    private String postCode;
    private String postNameFr;
    private String postNameNl;
    private String regionCode;

    @Override
    public int compareTo(MunicipalityDto other) {
        return this.municipalityNameFr.compareTo(other.getMunicipalityNameFr());
    }

}
