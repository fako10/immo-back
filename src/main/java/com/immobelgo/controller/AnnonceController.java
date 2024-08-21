package com.immobelgo.controller;

import com.immobelgo.dto.AnnonceDto;
import com.immobelgo.dto.AnnonceLight;
import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.entities.Annonce;
import com.immobelgo.services.AnnonceService;
import com.immobelgo.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class AnnonceController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/searchannnonces")
    public ResponseEntity<Page<AnnonceLight>> getAnnonces(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "3") int size,
                                                          @RequestBody AnnonceSearchDto annonceSearchDto
    ) {
        return  ResponseEntity.ok(searchService.findAllAnnonces(annonceSearchDto, page, size));
    }

    @PostMapping(value = "/saveannoncesFiles/{code}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAnnoncePhotos(@RequestParam("imageFiles") MultipartFile[] files,
                                               @PathVariable("code") String code
    ) throws IOException {
        return ResponseEntity.ok(annonceService.addPhotoToAnnonce(files, code));
    }

    @PostMapping(value = "/saveannonce",  produces = MediaType.APPLICATION_JSON_VALUE)
    public AnnonceDto saveAnnonce(@RequestBody AnnonceDto annonce) throws IOException {
        System.out.println(annonce);
        Annonce entity = annonceService.saveAnnonce(annonce);
        annonce.setId(entity.getId());
        return annonce;
    }

    @GetMapping("/searchannnoncescode/{codepostal}")
    public ResponseEntity<List<Annonce>> getAnnoncesCode(@PathVariable String codepostal) {
        return  ResponseEntity.ok(searchService.findAllAnnoncesCodePostal(codepostal));
    }

    @GetMapping("/searchannnoncecode/{codeAnnonce}")
    public ResponseEntity<AnnonceDto> getAnnonceCodeAnnonce(@PathVariable String codeAnnonce) {
        return  ResponseEntity.ok(searchService.findAnnonceByCodeAnnonce(codeAnnonce));
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        String test = "test";
        return  ResponseEntity.ok(test);
    }
}
