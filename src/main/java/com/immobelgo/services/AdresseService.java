package com.immobelgo.services;


import com.immobelgo.dto.MunicipalityDto;
import com.immobelgo.dto.StreetsDto;
import com.immobelgo.dto.mapper.MunicipalityMapper;
import com.immobelgo.dto.mapper.StreetsMapper;
import com.immobelgo.entities.Municipality;
import com.immobelgo.entities.Street;
import com.immobelgo.repository.MunicipalityRepository;
import com.immobelgo.repository.StreetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdresseService {

    @Autowired
    private StreetsRepository streetsRepository;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<StreetsDto> getAllStreets() {

        List<StreetsDto> streetsDtos = new ArrayList<>();
        List<Street> streets = streetsRepository.findAll();
        for(Street street : streets) {
            streetsDtos.add(StreetsMapper.toDto(street));
        }
        return streetsDtos;
    }

    public List<MunicipalityDto> getAllMunicipalities() {

        List<MunicipalityDto> municipalityDtos = new ArrayList<>();
        List<Municipality> municipalities = municipalityRepository.findAll();
        for(Municipality municipality : municipalities) {
            municipalityDtos.add(MunicipalityMapper.toDto(municipality));
        }
        System.out.println(municipalityDtos);
        return municipalityDtos;
    }

}
