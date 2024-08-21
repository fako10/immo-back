package com.immobelgo.entities.enume;

import com.immobelgo.helper.NullSafeUtil;

public enum Typechauffage {

    Charbon,
    Electricité,
    Gaz,
    Mazout,
    Bois,
    Pellets,
    Solaire;

    public static Typechauffage fromString(String name) {
        return NullSafeUtil.getEnumFromString(Typechauffage.class, name);
    }
}
