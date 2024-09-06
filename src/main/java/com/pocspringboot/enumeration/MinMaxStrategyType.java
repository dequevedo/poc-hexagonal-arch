package com.pocspringboot.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum MinMaxStrategyType {

    TRADITIONAL_LOOP("traditional_loop"),
    STREAM("stream");

    private final String fieldName;

    public static MinMaxStrategyType fromName(String name) {
        return Stream.of(values())
                .filter(strategyType -> strategyType.fieldName.equals(name))
                .findFirst()
                .orElse(null);
    }

}
