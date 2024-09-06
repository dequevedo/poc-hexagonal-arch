package com.pocspringboot.enumeration;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String name;

    public static Gender fromName(String name) {
        return Stream.of(values())
                .filter(race -> race.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
