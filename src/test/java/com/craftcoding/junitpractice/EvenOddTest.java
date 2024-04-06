package com.craftcoding.junitpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenOddTest {

    @Test
    void givenEvenNumber_whenIsEvenCalled_thenReturnTrue(){
        EvenOdd evenOdd = new EvenOdd();

        assertTrue(evenOdd.isEven(10));
    }
    @Test
    void givenOddNumber_whenIsEvenCalled_thenReturnFalse(){
        EvenOdd evenOdd = new EvenOdd();

        assertTrue(evenOdd.isEven(10));
    }
}
