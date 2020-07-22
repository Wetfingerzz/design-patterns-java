package com.example.patterns2.aop.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        //given
        //when
        double result = calculator.add(10,10);
        //then
        LOGGER.info("Testing add method");
        assertEquals(result,20,0.1);
    }
    @Test
    public void testSub() {
        //given
        //when
        double result = calculator.subtract(10,10);
        //then
        LOGGER.info("Testing subtract method");
        assertEquals(result,0,0.1);
    }
    @Test
    public void testMultiply() {
        //given
        //when
        double result = calculator.multiply(10,10);
        //then
        LOGGER.info("Testing multiply method");
        assertEquals(result,100,0.1);
    }
    @Test
    public void testDiv() {
        //given
        //when
        double result = calculator.divide(10,10);
        //then
        LOGGER.info("Testing divide method");
        assertEquals(result,1,0.1);
    }
    @Test
    public void testFactorial() {
        //given
        //when
        BigDecimal result = calculator.factorial(new BigDecimal("1000"));
        //then
        LOGGER.info("Testing factorial method");
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}
