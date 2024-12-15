package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    // Happy Test Cases

    @Test
    public void testValidFirstName() throws InvalidFirstNameException {
        assertDoesNotThrow(() -> UserRegistration.isValidFirstName("John"));
        assertDoesNotThrow(() -> UserRegistration.isValidFirstName("Alice"));
    }

    @Test
    public void testValidLastName() throws InvalidLastNameException {
        assertDoesNotThrow(() -> UserRegistration.isValidLastName("Doe"));
        assertDoesNotThrow(() -> UserRegistration.isValidLastName("Smith"));
    }

    @Test
    public void testValidEmail() throws InvalidEmailException {
        assertDoesNotThrow(() -> UserRegistration.isValidEmail("abc@yahoo.com"));
        assertDoesNotThrow(() -> UserRegistration.isValidEmail("abc-100@yahoo.com"));
        assertDoesNotThrow(() -> UserRegistration.isValidEmail("abc.100@yahoo.com"));
        assertDoesNotThrow(() -> UserRegistration.isValidEmail("abc+100@gmail.com"));
    }

    @Test
    public void testValidMobileNumber() throws InvalidMobileNumberException {
        assertDoesNotThrow(() -> UserRegistration.isValidMobileNumber("91 9876543210"));
        assertDoesNotThrow(() -> UserRegistration.isValidMobileNumber("1 1234567890"));
    }

    @Test
    public void testValidPassword() throws InvalidPasswordException {
        assertDoesNotThrow(() -> UserRegistration.isValidPassword("Password1!"));
        assertDoesNotThrow(() -> UserRegistration.isValidPassword("Passw0rd@123"));
    }

    // Sad Test Cases
    @Test
    public void testInvalidFirstName() {
        assertThrows(InvalidFirstNameException.class, () -> UserRegistration.isValidFirstName("jo"));
        assertThrows(InvalidFirstNameException.class, () -> UserRegistration.isValidFirstName("john"));
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(InvalidLastNameException.class, () -> UserRegistration.isValidLastName("do"));
        assertThrows(InvalidLastNameException.class, () -> UserRegistration.isValidLastName("doe"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(InvalidEmailException.class, () -> UserRegistration.isValidEmail("abc"));
        assertThrows(InvalidEmailException.class, () -> UserRegistration.isValidEmail("abc@.com.my"));
    }

    @Test
    public void testInvalidMobileNumber() {
        assertThrows(InvalidMobileNumberException.class, () -> UserRegistration.isValidMobileNumber("9876543210"));
        assertThrows(InvalidMobileNumberException.class, () -> UserRegistration.isValidMobileNumber("91 98765432"));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("password"));
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("password123"));
    }


}