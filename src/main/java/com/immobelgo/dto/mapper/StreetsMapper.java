package com.immobelgo.dto.mapper;

import com.immobelgo.dto.StreetsDto;
import com.immobelgo.entities.Street;

public class StreetsMapper {

    public static StreetsDto toDto(Street entity) {

        StreetsDto dto = new StreetsDto();
        dto.setStreetId(entity.getStreetId());
        dto.setMunicipalityId(entity.getMunicipalityId());
        dto.setMunicipalityNameDe(entity.getMunicipalityNameDe());
        dto.setMunicipalityNameFr(entity.getMunicipalityNameFr());
        dto.setMunicipalityNameNl(entity.getMunicipalityNameNl());
        dto.setPostCode(entity.getPostCode());
        dto.setPostNameFr(entity.getPostNameFr());
        dto.setPostNameNl(entity.getPostNameNl());
        dto.setStreetNameDe(entity.getStreetNameDe());
        dto.setStreetNameFr(entity.getStreetNameFr());
        dto.setStreetNameNl(entity.getStreetNameNl());
        dto.setRegionCode(entity.getRegionCode());
        return dto;

    }

}
