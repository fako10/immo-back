package com.immobelgo.services;

import com.immobelgo.dto.AdresseDto;
import com.immobelgo.dto.AnnonceDto;
import com.immobelgo.dto.InterieurDto;
import com.immobelgo.dto.PerformanceEnergetiqueDto;
import com.immobelgo.dto.PrixDto;
import com.immobelgo.dto.mapper.AnnonceMapper;
import com.immobelgo.dto.mapper.InterieurMapper;
import com.immobelgo.dto.mapper.PerformanceEnergetiqueMapper;
import com.immobelgo.dto.mapper.PrixMapper;
import com.immobelgo.entities.Adresse;
import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Interieur;
import com.immobelgo.entities.PerformanceEnergetique;
import com.immobelgo.entities.Photo;
import com.immobelgo.entities.Prix;
import com.immobelgo.helper.FileManagement;
import com.immobelgo.repository.AdresseRepository;
import com.immobelgo.repository.AnnonceRepository;
import com.immobelgo.repository.InterieurRepository;
import com.immobelgo.repository.PerformanceEnergetiqueRepository;
import com.immobelgo.repository.PhotoRepository;
import com.immobelgo.repository.PrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;


@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private PerformanceEnergetiqueRepository performanceEnergetiqueRepository;
    @Autowired
    private InterieurRepository interieurRepository;
    @Autowired
    private PrixRepository prixRepository;

    @Transactional
    public ResponseEntity<?> addPhotoToAnnonce(MultipartFile[] files, String code) throws IOException {
        Optional<Annonce> optionalAnnonce = annonceRepository.findByCodeAnnonce(code);
        if(optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            Boolean isfirst = true;
            for(MultipartFile file : files) {
                savePhoto(annonce, file, isfirst);
                isfirst = false;
            }
        }
        return ResponseEntity.ok(optionalAnnonce.orElse(new Annonce()));
    }

    private void savePhoto(Annonce annonce, MultipartFile file, Boolean isfisrt) throws IOException {
        Photo photo = new Photo();
        photo.setAnnonce(annonce);
        photo.setType(file.getContentType());
        photo.setBytePhoto(FileManagement.compressBytes(file.getBytes()));
        photo.setCodeAnnonce(annonce.getCodeAnnonce());
        photoRepository.save(photo);
        if(isfisrt) {
            annonce.setPhotoPresentation(FileManagement.compressBytes(file.getBytes()));
            annonceRepository.save(annonce);
        }
    }

    @Transactional
    public Annonce saveAnnonce(AnnonceDto annonceDto) throws IOException {

        AdresseDto adresseDto = annonceDto.getAdresse();
        //Specification<Adresse> specification = AdresseSpecification.filterAdresse(adresseDto);
        //List<Adresse> adresses = adresseRepository.findAll(specification);
        //Adresse adresse = new Adresse();
        /*if(adresses.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: adresse not valid"));
        } else {
            adresse = adresses.get(0);
        }*/

        Adresse adresse = adresseRepository.findById(1L).get();

        Annonce annonce = AnnonceMapper.toEntity(annonceDto);
        annonce.setAdresse(adresse);
        Date dateCreation = new Date();
        annonce.setDateCreation(dateCreation);
        annonceRepository.save(annonce);
        savePerformancePeb(annonceDto.getCertificationPeb(), annonce);
        saveInterieur(annonceDto.getInterieur(), annonce);
        savePrix(annonceDto.getPrix(), annonce);


        /*if(!annonceDto.getPhotos().isEmpty()) {
            annonce.setPhotoPresentation(annonceDto.getPhotos().get(0));
            for(MultipartFile photoByte : annonceDto.getPhotoList()) {
                Photo photo = new Photo();
                photo.setBytePhoto(compressBytes(photoByte.getBytes()));
                photo.setType(photoByte.getContentType());
                photo.setName(photoByte.getName());
                photo.setAnnonce(annonce);
                photoRepository.save(photo);
            }
        }*/

        return annonce;
    }

    private void savePerformancePeb(PerformanceEnergetiqueDto performanceEnergetiqueDto, Annonce annonce) {
        if(performanceEnergetiqueDto != null) {
            PerformanceEnergetique performanceEnergetique = PerformanceEnergetiqueMapper.toEntity(
                    performanceEnergetiqueDto,
                    annonce
            );
            performanceEnergetiqueRepository.save(performanceEnergetique);
        }
    }

    private void saveInterieur(InterieurDto interieurDto, Annonce annonce) {
        if(interieurDto != null) {
            Interieur interieur = InterieurMapper.toEntity(interieurDto, annonce);
            interieurRepository.save(interieur);
        }
    }

    private void savePrix(PrixDto prixDto, Annonce annonce) {
        if(prixDto != null) {
            Prix prix = PrixMapper.toEntity(prixDto, annonce);
            prixRepository.save(prix);
        }
    }


}



