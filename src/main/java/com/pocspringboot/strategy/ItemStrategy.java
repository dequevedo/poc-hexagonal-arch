package com.pocspringboot.strategy;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.ItemDomain;
import com.pocspringboot.model.request.CreateItemRequest;

public interface ItemStrategy {

    ItemType getItemType();

    ItemDomain createItem(CreateItemRequest createItemRequest);

    String returnSomethingCool(CreateItemRequest createItemRequest);

}
