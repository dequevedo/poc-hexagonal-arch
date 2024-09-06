package com.pocspringboot.strategy.factory;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.exception.StrategyNotFoundException;
import com.pocspringboot.strategy.FindMinMaxStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class MinMaxFactory {

    private final List<FindMinMaxStrategy> strategies;

    public FindMinMaxStrategy getFindMinMaxStrategy(MinMaxStrategyType strategyType) {
        return strategies.stream()
                .filter(s -> s.getStrategyType().equals(strategyType))
                .findFirst()
                .orElseThrow(StrategyNotFoundException::new);
    }

}
