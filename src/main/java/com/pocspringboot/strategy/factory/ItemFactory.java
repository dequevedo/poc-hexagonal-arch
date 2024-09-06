package com.pocspringboot.strategy.factory;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.strategy.ItemStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemFactory {

    private final List<ItemStrategy> strategies;

    public ItemStrategy getItemStrategy(ItemType itemType) throws NotImplementedException {
        return strategies.stream()
                .filter(itemStrategy -> itemStrategy.getItemType().equals(itemType))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("ItemType {itemType} is not implemented.");
                    return new NotImplementedException();
                });
    }

}
