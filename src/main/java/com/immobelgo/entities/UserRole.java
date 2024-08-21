package com.immobelgo.entities;

import java.util.stream.Stream;

public enum UserRole {

    USER, PROFESSIONNEL, AGENT_IMMOBILIER,ADMIN;

    public static UserRole toEnum(String val) {
        return Stream.of(values())
                .filter(enume -> enume.name().equalsIgnoreCase(val))
                .findFirst()
                .orElse(UserRole.USER);
    }
}
