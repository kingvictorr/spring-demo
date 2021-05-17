package com.example.demo;


import com.example.demo.controllers.OrderProcessingController;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment=SpringBootTest.WebEnvironment.MOCK,
        classes = DemoApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class OrderProcessingControllerIntegrationTest {
    @Autowired private MockMvc mvc;
    @Autowired private UserRepo userRepo;
    Logger logger = LoggerFactory.getLogger(OrderProcessingControllerIntegrationTest.class);

    @Test
    public void givenBill_persit_thenReturnBill() {

    }

    @Test
    public void givenUser_calculate_discount() {
        logger.info("---------------------------------");

        logger.trace(">GIVEN_USER_CALC_DISCOUNT");

        ArrayList<User> users = (ArrayList<User>) userRepo.findAll();

        users.forEach(u -> {
            try {
                mvc.perform(get("/orders/" + u.getId() + "/bills")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        logger.info("---------------------------------");
    }
}
