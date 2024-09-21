package com.immobelgo.dto.mapper;

import com.immobelgo.dto.MunicipalityDto;
import com.immobelgo.entities.Municipality;

public class MunicipalityMapper {

    public static MunicipalityDto toDto(Municipality entity) {

        MunicipalityDto dto = new MunicipalityDto();
        dto.setMunicipalityId(entity.getMunicipalityId());
        dto.setMunicipalityNameDe(entity.getMunicipalityNameDe());
        dto.setMunicipalityNameFr(entity.getMunicipalityNameFr());
        dto.setMunicipalityNameNl(entity.getMunicipalityNameNl());
        dto.setPostCode(entity.getPostCode());
        dto.setPostNameFr(entity.getPostNameFr());
        dto.setPostNameNl(entity.getPostNameNl());
        dto.setRegionCode(entity.getRegionCode());
        return dto;

    }
}
