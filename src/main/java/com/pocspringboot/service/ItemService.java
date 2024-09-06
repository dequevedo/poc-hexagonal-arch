package com.pocspringboot.service;

import com.pocspringboot.model.domain.items.ItemDomain;
import com.pocspringboot.model.request.CreateItemRequest;
import com.pocspringboot.repository.ItemRepository;
import com.pocspringboot.strategy.factory.ItemFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemFactory itemFactory;

    public void createItem(CreateItemRequest createItemRequest) {
        ItemDomain item = itemFactory.getItemStrategy(createItemRequest.getItemType()).createItem(createItemRequest);
        itemRepository.save(item);
    }
}
