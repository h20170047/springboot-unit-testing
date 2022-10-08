package com.svj.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"}) // This can be used to have diff test config for a given test
public class ItemControllerIT {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String output = this.restTemplate.getForObject("/items/all", String.class);
        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", output, false);
    }
}
