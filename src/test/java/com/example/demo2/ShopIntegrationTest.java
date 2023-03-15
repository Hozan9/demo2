package com.example.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc


public class ShopIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired


    @Test
    void getProduct() throws Exception {
        mockMvc.perform(get("products/{id}"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                            { "id":"1",
                            "name":"Apple"
                                            }
                        """
                ));
    }

    @Test
    @DirtiesContext
    void addProduct() throws Exception {
        mockMvc.perform(post("api/products").contentType(MediaType.APPLICATION_JSON).content("""
                {
                "name":"Apple",
                "id":"1"}
                """
        )).andExpect(status().isOk()).andExpect(content().json("""
                {
                "name":"Apple",
                "id":"1"}
                """
        ));
    }

}



