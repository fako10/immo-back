package com.immobelgo.dto;


import lombok.Data;
import java.util.List;

@Data
public class AnnonceDto {

    private Long                            id;
    private String                          codeAnnonce;
    private AdresseDto                      adresse;
    private PerformanceEnergetiqueDto       certificationPeb;
    private ExterieurDto                    exterieur;
    private InfobaseDto                     infoBase;
    private InfoGeneraleDto                 infoGenerale;
    private InterieurDto                    interieur;
    private PrixDto                         prix;
    private TitreEtDescription              titreEtDescription;
    private List<PhotoDto> photos;

}
