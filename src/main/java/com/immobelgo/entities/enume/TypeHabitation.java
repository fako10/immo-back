package com.immobelgo.entities.enume;

import com.immobelgo.helper.NullSafeUtil;

public enum TypeHabitation {

    Maison,
    Appartement,
    Terrain,
    Garage,
    Chambre,
    Studio;

    public static TypeHabitation fromString(String name) {
        return NullSafeUtil.getEnumFromString(TypeHabitation.class, name);
    }
}
