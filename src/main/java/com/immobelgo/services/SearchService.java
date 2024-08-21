package com.immobelgo.services;

import com.immobelgo.dto.AdresseDto;
import com.immobelgo.dto.AnnonceDto;
import com.immobelgo.dto.AnnonceLight;
import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.dto.ExterieurDto;
import com.immobelgo.dto.InfoGeneraleDto;
import com.immobelgo.dto.InterieurDto;
import com.immobelgo.dto.PerformanceEnergetiqueDto;
import com.immobelgo.dto.PhotoDto;
import com.immobelgo.dto.PrixDto;
import com.immobelgo.dto.mapper.AdresseMapper;
import com.immobelgo.dto.mapper.AnnonceMapper;
import com.immobelgo.dto.mapper.ExterieurMapper;
import com.immobelgo.dto.mapper.InfoBaseMapper;
import com.immobelgo.dto.mapper.InfoGeneraleMapper;
import com.immobelgo.dto.mapper.InterieurMapper;
import com.immobelgo.dto.mapper.PerformanceEnergetiqueMapper;
import com.immobelgo.dto.mapper.PrixMapper;
import com.immobelgo.dto.mapper.TitreEtDescriptionMapper;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Exterieur;
import com.immobelgo.entities.Interieur;
import com.immobelgo.entities.PerformanceEnergetique;
import com.immobelgo.entities.Photo;
import com.immobelgo.entities.Prix;
import com.immobelgo.helper.FileManagement;
import com.immobelgo.repository.AdresseRepository;
import com.immobelgo.repository.AnnonceRepository;
import com.immobelgo.repository.ExterieurRepository;
import com.immobelgo.repository.InterieurRepository;
import com.immobelgo.repository.PerformanceEnergetiqueRepository;
import com.immobelgo.repository.PhotoRepository;
import com.immobelgo.repository.PrixRepository;
import com.immobelgo.repository.specifications.AnnonceSpecification;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private AdresseRepository adresseRepository;
    
    @Autowired
    private PerformanceEnergetiqueRepository performanceEnergetiqueRepository;

    @Autowired
    ExterieurRepository exterieurRepository;

    @Autowired
    InterieurRepository interieurRepository;

    @Autowired
    PrixRepository prixRepository;

    @Autowired
    PhotoRepository photoRepository;

    public Page<AnnonceLight> findAllAnnonces(AnnonceSearchDto annonceSearchDto, Integer page, Integer size) {
        Specification<Annonce> specification = AnnonceSpecification.filterAnnonce(annonceSearchDto);
        final Page<AnnonceLight> annonceLightPage;
        List<Annonce> annonces = annonceRepository.findAll(specification);
        List<AnnonceLight> annonceLights = new ArrayList<>();
        for(Annonce annonce : annonces) {
            AnnonceLight annonceLight = AnnonceMapper.toDtoLight(annonce);
            annonceLights.add(annonceLight);
        }
        Pageable pageable = PageRequest.of(page, size);
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), annonceLights.size());
        if (CollectionUtils.isNotEmpty(annonceLights)) {
            annonceLightPage = new PageImpl<>(annonceLights.subList(start, end), pageable, annonceLights.size());
        } else {
            annonceLightPage = new PageImpl<>(annonceLights, pageable, 0);
        }

        return annonceLightPage;
    }

    public List<Annonce> findAllAnnoncesCodePostal(String codePostal) {
        AnnonceSearchDto annonceSearchDto = new AnnonceSearchDto();
        annonceSearchDto.setCommuneOuCodePostal(codePostal);
        annonceSearchDto.setNbrMaxChambre(3L);
        Specification<Annonce> specification = AnnonceSpecification.filterAnnonce(annonceSearchDto);
        return annonceRepository.findAll(specification);
    }

    public AnnonceDto findAnnonceByCodeAnnonce(String codeAnnonce) {

        Optional<Annonce> optionalAnnonce = annonceRepository.findByCodeAnnonce(codeAnnonce);
        AnnonceDto annonceDto = new AnnonceDto();
        if(optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            annonceDto.setId(annonce.getId());
            annonceDto.setCodeAnnonce(annonce.getCodeAnnonce());
            

            annonceDto.setAdresse(getAdresseDto(annonce));
            annonceDto.setCertificationPeb(getPerformanceEnergetiqueDto(annonce));
            annonceDto.setExterieur(getExterieurDto(annonce));
            annonceDto.setInfoBase(InfoBaseMapper.toDto(annonce));
            annonceDto.setInfoGenerale(InfoGeneraleMapper.toDto(annonce));
            annonceDto.setInterieur(getInterieurDto(annonce));
            annonceDto.setPrix(getPrixDto(annonce));
            annonceDto.setTitreEtDescription(TitreEtDescriptionMapper.toDto(annonce));
            annonceDto.setPhotos(getPhotos(annonce));

        }
        return annonceDto;
    }

    private AdresseDto getAdresseDto(Annonce annonce) {
        AdresseDto adresseDto = new AdresseDto();
        if(annonce.getAdresse() != null) {
            adresseDto = AdresseMapper.toDto(annonce.getAdresse());
        }
        return adresseDto;
    }
    
    private PerformanceEnergetiqueDto getPerformanceEnergetiqueDto(Annonce annonce) {
        PerformanceEnergetiqueDto performanceEnergetiqueDto = new PerformanceEnergetiqueDto();
        Optional<PerformanceEnergetique> optionalPerformanceEnergetique = performanceEnergetiqueRepository.findByAnnonce(annonce);
        if(optionalPerformanceEnergetique.isPresent()) {
            performanceEnergetiqueDto = PerformanceEnergetiqueMapper.toDto(optionalPerformanceEnergetique.get());
        }
        return performanceEnergetiqueDto;
    }

    private ExterieurDto getExterieurDto(Annonce annonce) {
        ExterieurDto exterieurDto = new ExterieurDto();
        Optional<Exterieur> optionalExterieur = exterieurRepository.findByAnnonce(annonce);
        if(optionalExterieur.isPresent()) {
            exterieurDto = ExterieurMapper.toDto(optionalExterieur.get());
        }
        return exterieurDto;
    }

    private InterieurDto getInterieurDto(Annonce annonce) {
        InterieurDto interieurDto = new InterieurDto();
        Optional<Interieur> optionalInterieur = interieurRepository.findByAnnonce(annonce);
        if(optionalInterieur.isPresent()) {
            interieurDto = InterieurMapper.toDto(optionalInterieur.get());
        }
        return interieurDto;
    }

    private PrixDto getPrixDto(Annonce annonce) {
        PrixDto prixDto = new PrixDto();
        Optional<Prix> optionalPrix = prixRepository.findByAnnonce(annonce);
        if(optionalPrix.isPresent()) {
            prixDto = PrixMapper.toDto(optionalPrix.get(), annonce);
        }
        return prixDto;
    }

    private List<PhotoDto> getPhotos(Annonce annonce) {
        List<PhotoDto> photoDtos = new ArrayList<>();
        List<Photo> photos = photoRepository.getAllByAnnonce(annonce);
        Integer pos = 0;
        for(Photo photo : photos) {
            PhotoDto photoDto = new PhotoDto();
            photoDto.setPosition(pos);
            photoDto.setBytePhoto(FileManagement.decompressBytes(photo.getBytePhoto()));
            photoDtos.add(photoDto);
            pos++;
        }
        return photoDtos;
    }

}
