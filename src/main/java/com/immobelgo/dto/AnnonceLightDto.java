package com.immobelgo.dto;

import com.immobelgo.entities.Interieur;
import com.immobelgo.entities.enume.EtatBatimentEnum;
import com.immobelgo.entities.enume.TypeTransaction;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


@Data
public class AnnonceLightDto {

    private long id;
    private String codeAnnonce;
    private Integer nbrFacade;
    private String typeTransaction;
    private Long nbrChambre;
    private Long largeurFacade;
    private Long surfaceHabitable;
    private Long surfaceTerrain;
    private Integer nbrEtage;
    private String anneeConstruction;
    private EtatBatimentEnum etatBatiment;
    private Boolean ascenseur;
    private Boolean accesHandicape;
    private Boolean meuble;
    private Boolean gardien;
    private Boolean parking;
    private Integer nbrPlaceParking;
    private Boolean concierge;
    private String disponibilite;
    private String titreFr;
    private String descriptionFr;
    private String titreNl;
    private String descriptionNl;
    private String codePostal;
    private String commune;
    private String rue;
    private String numero;
    private Long prix;
    private List<byte[]> photos;
    private List<MultipartFile> photoList;
    private byte[] video;
    private String boite;
    private Date dateCreation;

    //private AdresseDto adresse;
}
