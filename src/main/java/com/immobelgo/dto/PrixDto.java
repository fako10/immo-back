package com.immobelgo.dto;

import lombok.Data;

@Data
public class PrixDto {

    private Long id;
    private Long prixVente;
    private Long revenuCadastre;
    private Long tva;
    private Long charges;
    private Long prixMetreCarre;

}
