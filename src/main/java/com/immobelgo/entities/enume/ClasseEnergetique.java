package com.immobelgo.entities.enume;

import com.immobelgo.helper.NullSafeUtil;

public enum ClasseEnergetique {

    A("A"),
    A_PLUS("A+"),
    A_PLUS_PLUS("A++"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");



    public final String libelle;

    public static ClasseEnergetique fromString(String name) {
        return NullSafeUtil.getEnumFromString(ClasseEnergetique.class, name);
    }

    private ClasseEnergetique(String libelle) {
        this.libelle = libelle;
    }
}
