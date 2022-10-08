package com.svj.service;

import com.svj.model.Item;
import com.svj.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    private ItemRepository repo;

    public ItemService(ItemRepository itemRepository){
        repo= itemRepository;
    }

    public Item retrieveItem() {
        return new Item("Book", 1, 200, 1, 200);
    }

    public List<Item> retrieveAllItems(){
        List<Item> allItems = repo.findAll();
        for(Item processingItem: allItems){
            processingItem.setValue(processingItem.getQuantity()* processingItem.getPrice());
        }
        return allItems;
    }

    public Item retrieveItemWithId(String id) {
        return repo.getItemWithID(id);
    }

    public Item addItem(Item item) {
        return repo.save(item);
    }
}
