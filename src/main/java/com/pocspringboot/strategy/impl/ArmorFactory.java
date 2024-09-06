package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.Armor;
import com.pocspringboot.model.request.CreateItemRequest;
import com.pocspringboot.strategy.ItemStrategy;

public class ArmorFactory implements ItemStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.ARMOR;
    }

    @Override
    public Armor createItem(CreateItemRequest createItemRequest) {
        return Armor.builder()
                .name(createItemRequest.getName())
                .value(createItemRequest.getValue())
                .weight(createItemRequest.getWeight())
                .image(createItemRequest.getImage())
                .description(createItemRequest.getDescription())
                .rarity(createItemRequest.getRarity())
                .defense(createItemRequest.getDefense())
                .build();
    }

    @Override
    public String returnSomethingCool(CreateItemRequest createItemRequest) {
        return "THIS IS AN ARMOR FACTORY!";
    }

}
