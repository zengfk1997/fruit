package org.example.fruit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class FruitCostServiceTest {
    @Autowired
    private FruitCostService fruitCostService;

    @Test
    void firstQuestion() throws Exception {
        BigDecimal expected = new BigDecimal("105.00");
        Assertions.assertEquals(expected, fruitCostService.firstQuestion(5, 5));
    }

    @Test
    void secondQuestion() throws Exception {
        BigDecimal expected = new BigDecimal("205.00");
        Assertions.assertEquals(expected, fruitCostService.secondQuestion(5, 5, 5));
    }

    @Test
    void thirdQuestion() throws Exception {
        BigDecimal expected = new BigDecimal("192.00");
        Assertions.assertEquals(expected,
                fruitCostService.thirdQuestion(5, 5, 5, 0.8));
    }

    @Test
    void fourthQuestion() throws Exception {
        BigDecimal expected = new BigDecimal("195.00");
        Assertions.assertEquals(expected,
                fruitCostService.fourthQuestion(5, 5, 5));
    }
}