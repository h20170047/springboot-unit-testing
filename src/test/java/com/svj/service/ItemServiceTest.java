package com.svj.service;

import com.svj.model.Item;
import com.svj.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository repository;

    @Test
    public void testAllItemsValueCalc(){
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Item("Item1", 1, 100, 3, 0),
                        new Item("Item2", 2, 200, 5, 0)
                )
        );
        List<Item> allItems = itemService.retrieveAllItems();
        assertEquals(300, allItems.get(0).getValue());
        assertEquals(1000, allItems.get(1).getValue());
    }

}