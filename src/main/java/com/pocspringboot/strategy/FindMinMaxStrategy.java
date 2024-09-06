package com.pocspringboot.strategy;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.response.training.FindMaxMinResponse;

import java.util.List;

public interface FindMinMaxStrategy {

    MinMaxStrategyType getStrategyType();

    FindMaxMinResponse findMinMaxResponse(List<Product> products);

}
