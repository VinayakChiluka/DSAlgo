package com.craftcoding.junitpractice;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static com.craftcoding.junitpractice.StringUtils.reverse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringUtilsTest_NotNull {

    @Test
    void givenNullString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse(null);
        Supplier<String> supplierMessage = ()-> "Actual String should be null!";
        assertNotNull(actual, supplierMessage);
    }

    @Test
    void givenEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("");
        assertNotNull(actual, "Actual String should be null!");
    }

    @Test
    void givenNonEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("ABCD");
        Supplier<String> message =  () -> "Actual String should be Null!";
        assertNotNull(actual);
    }
}
