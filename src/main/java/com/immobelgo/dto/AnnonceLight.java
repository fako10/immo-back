package com.immobelgo.dto;

import com.immobelgo.entities.enume.TypeTransaction;
import lombok.Data;

import java.util.Date;

@Data
public class AnnonceLight {

    private long id;
    private String codeAnnonce;
    private String typeTransaction;
    private Long nbrChambre;
    private String titreFr;
    private String descriptionFr;
    private String titreNl;
    private String descriptionNl;
    private String codePostal;
    private String commune;
    private Long prix;
    private byte[] photo;
    private Date dateCreation;
}
