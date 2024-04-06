package com.craftcoding.junitpractice;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static com.craftcoding.junitpractice.StringUtils.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringUtilsTest {

    @Test
    void givenNullString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse(null);
        assertNull(actual);
    }

    @Test
    void givenEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("");
        assertNull(actual, "Actual String should be null!");
    }

    @Test
    void givenNonEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("ABCD");
        Supplier<String> message =  () -> "Actual String should be Null!";
        assertNull(actual);
    }
}
