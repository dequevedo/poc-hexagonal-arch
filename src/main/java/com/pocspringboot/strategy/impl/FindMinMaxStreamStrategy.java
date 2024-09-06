package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.exception.NotFoundException;
import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.response.training.FindMaxMinResponse;
import com.pocspringboot.strategy.FindMinMaxStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindMinMaxStreamStrategy implements FindMinMaxStrategy {

    @Override
    public MinMaxStrategyType getStrategyType() {
        return MinMaxStrategyType.STREAM;
    }

    @Override
    public FindMaxMinResponse findMinMaxResponse(List<Product> products) {
        Product min = products.stream()
                .min((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .orElseThrow(NotFoundException::new);

        Product max = products.stream()
                .max((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .orElseThrow(NotFoundException::new);

        return FindMaxMinResponse.builder()
                .min(min)
                .max(max)
                .build();
    }

}
