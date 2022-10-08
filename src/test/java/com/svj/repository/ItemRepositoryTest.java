package com.svj.repository;

import com.svj.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    public void findWithId(){
        Item items = repository.getItemWithID("10001");
        assertEquals("Item1", items.getName());
    }
}