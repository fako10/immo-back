package com.immobelgo.dto;

import lombok.Data;

@Data
public class SousTypeHabitationDto {

    private Long id;
    private Long libelle;
    private String description;
    private TypeHabitationDto typeHabitation;

}
