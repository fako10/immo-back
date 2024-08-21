package com.immobelgo.entities.enume;

public enum SousTypeHabitation {

    Bungalow(TypeHabitation.Maison),
    Immeuble(TypeHabitation.Maison);



    private final TypeHabitation typeHabitation;

    SousTypeHabitation(TypeHabitation typeHabitation) {
        this.typeHabitation = typeHabitation;
    }
}
