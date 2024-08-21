package com.immobelgo.controller;

import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.services.AnnonceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/searchannonce")
public class AnnonceSearchController {

    @Autowired
    private AnnonceSearchService annonceSearchService;

    @GetMapping ("/listbyuser")
    public List<AnnonceSearchDto> getAnnonceSearchByUser() {
        return  annonceSearchService.getAnnonceByUser();
    }

    @PostMapping("/save")
    public AnnonceSearchDto saveAnnonceSearch(@RequestBody AnnonceSearchDto annonceSearchDto) {
        return annonceSearchService.saveAnnonceSearch(annonceSearchDto);
    }

    @GetMapping ("/find/{id}")
    public AnnonceSearchDto getAnnonceSearch(@PathVariable Long id) {
        return  annonceSearchService.getAnnonceSearchById(id);
    }

}
