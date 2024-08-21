package com.immobelgo.entities.enume;

import com.immobelgo.helper.NullSafeUtil;

public enum EtatBatimentEnum {

    Bon("Bon"),
    Excellent("Excellent état"),
    A_Restaurer("A restaurer"),
    Fraichement_Renove("Fraîchement rénové"),
    A_Rafraichir("A rafraîchir"),
    A_Renover("A rénover");

    public String libelle;

    private EtatBatimentEnum(String libelle) {
        this.libelle = libelle;
    }

    public static EtatBatimentEnum fromString(String name) {
        return NullSafeUtil.getEnumFromString(EtatBatimentEnum.class, name);
    }
}