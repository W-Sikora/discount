package util;

import model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static util.Validator.*;
import static util.Validator.validateCurrencyValue;

class ValidatorTest {

    private static final Class<IllegalArgumentException> EXCEPTION_CLASS = IllegalArgumentException.class;

    @Test
    @DisplayName("should throw exception if currency value is null")
    void shouldThrowExceptionIfCurrencyValueIsNull() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateCurrencyValue(null));
        assertEquals(NULL_CURRENCY_VALUE_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if currency value contains negative number")
    void shouldThrowExceptionIfCurrencyValueContainsNegativeNumber() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateCurrencyValue(new BigDecimal("-1.23")));
        assertEquals(NEGATIVE_NUMBER_CURRENCY_VALUE_MESSAGE, exception.getMessage());
    }


    @Test
    @DisplayName("should throw exception if currency value has too many decimal places")
    void shouldThrowExceptionIfCurrencyValueHasTooManyDecimalPlaces() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateCurrencyValue(new BigDecimal("12.345")));
        assertEquals(INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if currency value has too few decimal places")
    void shouldThrowExceptionIfCurrencyValueHasTooFewDecimalPlaces() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateCurrencyValue(new BigDecimal("1.2")));
        assertEquals(INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if currency value does not have decimal places")
    void shouldThrowExceptionIfCurrencyValueDoesNotHaveDecimalPlaces() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateCurrencyValue(new BigDecimal("1")));
        assertEquals(INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if list is empty")
    void shouldThrowExceptionIfListIsEmpty() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateProducts(Collections.emptyList()));
        assertEquals(INCORRECT_LIST_SIZE_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if list is too large")
    void shouldThrowExceptionIfListIsTooLarge() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS, () -> validateProducts(List.of(
                new Product("Test1", new BigDecimal("12.34")),
                new Product("Test2", new BigDecimal("12.34")),
                new Product("Test3", new BigDecimal("12.34")),
                new Product("Test4", new BigDecimal("12.34")),
                new Product("Test5", new BigDecimal("12.34")),
                new Product("Test6", new BigDecimal("12.34"))
        )));
        assertEquals(INCORRECT_LIST_SIZE_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if product name is null")
    void shouldThrowExceptionIfProductNameIsNull() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateProducts(List.of(new Product(null, new BigDecimal("10.00")))));
        assertEquals(NULL_NAME_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if product name is empty")
    void shouldThrowExceptionIfProductNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateProducts(List.of(new Product("", new BigDecimal("1.00")))));
        assertEquals(EMPTY_NAME_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception if product name is blank")
    void shouldThrowExceptionIfProductNameIsBlank() {
        IllegalArgumentException exception = assertThrows(EXCEPTION_CLASS,
                () -> validateProducts(List.of(new Product(" ", new BigDecimal("1.00")))));
        assertEquals(BLANK_NAME_MESSAGE, exception.getMessage());
    }

}
