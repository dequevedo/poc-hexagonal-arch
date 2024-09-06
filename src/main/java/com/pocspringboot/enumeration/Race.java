package com.pocspringboot.enumeration;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public enum Race {
    DRAGONBORN("Dragonborn"),
    DWARF("Dwarf"),
    ELF("Elf"),
    GNOME("Gnome"),
    HALF_ELF("Half Elf"),
    HALFLING("Halfling"),
    HALF_ORC("Half Orc"),
    HUMAN("Human"),
    TIEFLING("Thiefling");

    private final String name;

    public static Race fromName(String name) {
        return Stream.of(values())
                .filter(race -> race.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
