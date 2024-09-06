package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.response.training.FindMaxMinResponse;
import com.pocspringboot.strategy.FindMinMaxStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindMinMaxTraditionalLoopStrategy implements FindMinMaxStrategy {

    @Override
    public MinMaxStrategyType getStrategyType() {
        return MinMaxStrategyType.TRADITIONAL_LOOP;
    }

    @Override
    public FindMaxMinResponse findMinMaxResponse(List<Product> products) {
        Product min = products.get(0);
        Product max = products.get(0);

        for (Product product : products) {
            if(product.getPrice().compareTo(min.getPrice()) < 0) min = product;
            if(product.getPrice().compareTo(max.getPrice()) > 0) max = product;
        }

        return FindMaxMinResponse.builder()
                .min(min)
                .max(max)
                .build();
    }

}
