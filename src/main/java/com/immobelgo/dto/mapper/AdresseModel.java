package com.immobelgo.dto.mapper;

import lombok.Data;

@Data
public class AdresseModel {

    Long   id;
    String pays;
    String villeFr;
    String villeNl;
    String codePostal;
    String communeFr;
    String communeNl;
    String rue;
    String rueFr;
    String rueNl;
    String numero;
    String boite;

}
