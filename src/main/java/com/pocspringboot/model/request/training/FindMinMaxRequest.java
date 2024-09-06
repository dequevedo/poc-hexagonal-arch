package com.pocspringboot.model.request.training;

import com.pocspringboot.validation.annotations.ValidMinMaxStrategyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindMinMaxRequest {

    @ValidMinMaxStrategyType
    private String strategy;

    private List<Product> products;

}