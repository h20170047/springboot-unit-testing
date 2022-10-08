package com.svj.controller;

import com.svj.model.Item;
import com.svj.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemService service;

    @Test
    public void getAnItem() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Book\",\"id\":1,\"price\":200.0,\"quantity\":1}"))
                .andReturn();
    }

    @Test
    public void getAnItemFromService() throws Exception {
        when(service.retrieveItem()).thenReturn(new Item("Book", 1, 200, 1, 500));
        RequestBuilder request= MockMvcRequestBuilders
                .get("/items/business")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{name:Book,id:1,price:200.0,quantity:1}"))
                .andReturn();
    }

    @Test
    public void getAllItemsFromService() throws Exception {
        when(service.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item("Book", 1, 200, 1, 500),
                        new Item("Book2", 2, 300, 20, 100)
                )
        );
        RequestBuilder request= MockMvcRequestBuilders
                .get("/items/all")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{name:Book,id:1,price:200.0,quantity:1}, {name:Book2,id:2,price:300.0,quantity:20}]"))
                .andReturn();
    }

    @Test
    public void createAnItem() throws Exception {
        when(service.addItem(any(Item.class))).thenReturn(
                new Item("Book", 1, 200, 1, 500)
        );
        RequestBuilder request= MockMvcRequestBuilders
                .post("/items")
                .content("{\"name\":\"Book\",\"id\":1,\"price\":200.0,\"quantity\":1,\"value\":500.0}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Book"))
                .andReturn();
        System.out.println(result);
    }

}