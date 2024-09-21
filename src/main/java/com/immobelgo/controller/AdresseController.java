package com.immobelgo.controller;


import com.immobelgo.dto.MunicipalityDto;
import com.immobelgo.dto.StreetsDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.services.AdresseService;
import com.immobelgo.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @GetMapping("/findAll")
    public ResponseEntity<List<MunicipalityDto>> getStreets() {
        return  ResponseEntity.ok(adresseService.getAllMunicipalities());
    }

}
