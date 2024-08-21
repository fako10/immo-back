package com.immobelgo.helper;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

@Slf4j
public class NullSafeUtil {


    /**
     * converti une chaine de caractères en énumération.
     *
     * @param c      : l'énumaration
     * @param string :  la chaine de caractère.
     * @param <T>    : type de l'énumaration
     * @return :  l'énumaration
     */
    public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if (c != null && string != null) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase(Locale.FRANCE));
            } catch (IllegalArgumentException e) {
                //log.trace(ERROR_CAUGHT_BY_NULL_SAFE_UTIL, e);
                return null;
            }
        }
        return null;
    }
}
