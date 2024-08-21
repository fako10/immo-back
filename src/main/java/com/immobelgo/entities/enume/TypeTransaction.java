package com.immobelgo.entities.enume;

import com.immobelgo.helper.NullSafeUtil;

public enum TypeTransaction {

    Acheter,
    Louer;

    public String libelle;

    public static TypeTransaction fromString(String name) {
        return NullSafeUtil.getEnumFromString(TypeTransaction.class, name);
    }


}
