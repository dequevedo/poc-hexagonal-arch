package com.pocspringboot.service;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.model.request.training.FindMinMaxRequest;
import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.request.training.TrainingNumberReverseRequest;
import com.pocspringboot.model.request.training.ProductListRequest;
import com.pocspringboot.model.response.training.FindMaxMinResponse;
import com.pocspringboot.model.response.training.ProductListResponse;
import com.pocspringboot.model.response.training.SumEvenOddResponse;
import com.pocspringboot.strategy.FindMinMaxStrategy;
import com.pocspringboot.strategy.factory.MinMaxFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService {

    private final MinMaxFactory minMaxFactory;

    public Integer reverseString(TrainingNumberReverseRequest request) {
        int signal = (int) Math.signum(request.getNumber());
        String reversedString = new StringBuilder(String.valueOf(Math.abs(request.getNumber()))).reverse().toString();
        return Integer.parseInt(reversedString) * signal;
    }

    public Double calculateProductsPriceSum(ProductListRequest request) {
        return request.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (accumulator, combiner) -> {
                    log.info(String.format("Accumulator: %s Combiner: %s", accumulator, combiner));
                    return accumulator + combiner;
                });
    }

    public Double calculateProductPriceAverage(ProductListRequest request) {
        return request.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<String> convertUppercaseToLowercase(ProductListRequest request) {
        return request.getProducts().stream()
                .map(Product::getName)
                .map(String::toLowerCase)
                .toList();
    }

    public SumEvenOddResponse calculateSumEvenOdd(ProductListRequest request) {
        Long evenSum = request.getProducts().stream()
                .map(Product::getId)
                .reduce(0L, (accumulator, id) -> {
                    boolean isEven = id % 2 == 0;
                    return isEven ? accumulator + 1 : accumulator;
                });

        return SumEvenOddResponse.builder()
                .even(evenSum)
                .odd(request.getProducts().size() - evenSum)
                .build();
    }

    public ProductListResponse removeDuplicatesIdFromRequest(ProductListRequest request) {
        Set<Long> uniqueIds = request.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toSet());
        log.info(String.format("uniqueIds: %s", uniqueIds));

        List<Product> productList = request.getProducts().stream()
                .filter(product -> {
                    boolean isInSet = uniqueIds.contains(product.getId());
                    if (isInSet) uniqueIds.remove(product.getId());
                    return isInSet;
                })
                .toList();

        return ProductListResponse.builder()
                .products(productList)
                .build();
    }

    public Long countFirstLetter(ProductListRequest request, String letter) {
        return request.getProducts().stream()
                .map(Product::getName)
                .filter(name -> name.startsWith(letter))
                .count();
    }

    public ProductListResponse sortAlphabetical(ProductListRequest request) {
        ProductListResponse response = new ProductListResponse();
        request.getProducts().stream()
                .sorted(Comparator.comparing(o -> o.getName().toLowerCase()))
                .forEach(p -> response.getProducts().add(p));
        return response;
    }

    public FindMaxMinResponse findMinMax(FindMinMaxRequest request) {
        FindMinMaxStrategy findMinMaxStrategy = minMaxFactory.getFindMinMaxStrategy(MinMaxStrategyType.fromName(request.getStrategy()));
        return findMinMaxStrategy.findMinMaxResponse(request.getProducts());
    }

    public void functionalConsumer() {
        Consumer<String> consumer = input -> log.info(input.concat("Something else"));
        consumer.accept("Input1");
        consumer.accept("Input2");
    }

    public List<String> functionalSupplier() {
        Supplier<List<String>> supplier = () -> Arrays.asList("1", "2", "3");
        return supplier.get();
    }

    public String functionalPredicate(String word) {
        Predicate<String> hasTenChars = str -> str.chars().count() == 10;
        String success = String.format("%s has 10 letters", word);
        String fail = String.format("%s doesn't have 10 letters", word);
        return hasTenChars.test(word) ? success : fail;
    }

    public String functionalFunction(String word) {
        Function<String, Integer> countChars = input -> Math.toIntExact(input.chars().count());
        return String.format("The given word has %s letters", countChars.apply(word));
    }

}
