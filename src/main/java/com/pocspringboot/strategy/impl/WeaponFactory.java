package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.Weapon;
import com.pocspringboot.model.request.CreateItemRequest;
import com.pocspringboot.strategy.ItemStrategy;

public class WeaponFactory implements ItemStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }

    @Override
    public Weapon createItem(CreateItemRequest createItemRequest) {
        return Weapon.builder()
                .name(createItemRequest.getName())
                .value(createItemRequest.getValue())
                .weight(createItemRequest.getWeight())
                .image(createItemRequest.getImage())
                .description(createItemRequest.getDescription())
                .rarity(createItemRequest.getRarity())
                .damage(createItemRequest.getDamage())
                .build();
    }

    @Override
    public String returnSomethingCool(CreateItemRequest createItemRequest) {
        return "THIS IS AN WEAPON FACTORY!";
    }

}
