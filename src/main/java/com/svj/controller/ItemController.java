package com.svj.controller;

import com.svj.model.Item;
import com.svj.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemService businessService;

    public ItemController(ItemService service){
        businessService= service;
    }

    @GetMapping("/items")
    public Item helloWorld(){
        return new Item("Book", 1, 200, 1, 500);
    }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item){
        return businessService.addItem(item);
    }

    @GetMapping("/items/business")
    public Item businessItem(){
        return businessService.retrieveItem();
    }

    @GetMapping("/items/all")
    public List<Item> getAllItems(){
        return businessService.retrieveAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItemWithId(@PathVariable String id){
        return businessService.retrieveItemWithId(id);
    }
}
