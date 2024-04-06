package com.craftcoding.junitpractice;

import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static com.craftcoding.junitpractice.StringUtils.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest_Equal {

    @Test
    void givenNullString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse(null);
        String expected = null;
        Supplier<String> stringSupplier = ()-> "Actual String should be Null!!!";
        assertEquals(expected, actual, stringSupplier);
    }

    @Test
    void givenEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("");
        String expected = "";
        Supplier<String> stringSupplier = () -> "Actual String should be empty!!!";
        assertEquals(expected, actual, stringSupplier);
    }

    @Test
    void givenNonEmptyString_whenUtilsStringCalled_thenReturnNull(){
        String actual = reverse("ABCD");
        String expected = "DCBA";
        Supplier<String> message =  () ->String.format("Actual `%s` should be Same as `%s`",actual, expected);
        assertEquals(actual,expected, message);
    }
}
