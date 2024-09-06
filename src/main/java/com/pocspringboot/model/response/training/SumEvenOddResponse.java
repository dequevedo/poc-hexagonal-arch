package com.pocspringboot.model.response.training;

import com.pocspringboot.model.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SumEvenOddResponse {

    private Long even;

    private Long odd;

}