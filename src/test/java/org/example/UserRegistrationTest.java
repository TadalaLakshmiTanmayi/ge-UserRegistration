package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    // Happy Test Cases

    @Test
    public void testValidFirstName() {
        assertTrue(UserRegistration.isValidFirstName("John"));
        assertTrue(UserRegistration.isValidFirstName("Alice"));
    }

    @Test
    public void testValidLastName() {
        assertTrue(UserRegistration.isValidLastName("Doe"));
        assertTrue(UserRegistration.isValidLastName("Smith"));
    }

    @Test
    public void testValidEmail() {
        assertTrue(UserRegistration.isValidEmail("abc@yahoo.com"));
        assertTrue(UserRegistration.isValidEmail("abc-100@yahoo.com"));
        assertTrue(UserRegistration.isValidEmail("abc.100@yahoo.com"));
        assertTrue(UserRegistration.isValidEmail("abc+100@gmail.com"));
    }

    @Test
    public void testValidMobileNumber() {
        assertTrue(UserRegistration.isValidMobileNumber("91 9876543210"));
        assertTrue(UserRegistration.isValidMobileNumber("1 1234567890"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(UserRegistration.isValidPassword("Password1!"));
        assertTrue(UserRegistration.isValidPassword("Passw0rd@123"));
    }

    // Sad Test Cases

    @Test
    public void testInvalidFirstName() {
        assertFalse(UserRegistration.isValidFirstName("jo"));
        assertFalse(UserRegistration.isValidFirstName("john"));
        assertFalse(UserRegistration.isValidFirstName("12345"));
        assertFalse(UserRegistration.isValidFirstName("J"));
    }

    @Test
    public void testInvalidLastName() {
        assertFalse(UserRegistration.isValidLastName("do"));
        assertFalse(UserRegistration.isValidLastName("doe"));
        assertFalse(UserRegistration.isValidLastName("12345"));
        assertFalse(UserRegistration.isValidLastName("D"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(UserRegistration.isValidEmail("abc"));
        assertFalse(UserRegistration.isValidEmail("abc@.com.my"));
        assertFalse(UserRegistration.isValidEmail("abc123@gmail.a"));
        assertFalse(UserRegistration.isValidEmail("abc123@.com"));
        assertFalse(UserRegistration.isValidEmail("abc@abc@gmail.com"));
        assertFalse(UserRegistration.isValidEmail("abc@%*.com"));
        assertFalse(UserRegistration.isValidEmail("abc..2002@gmail.com"));
        assertFalse(UserRegistration.isValidEmail("abc.@gmail.com"));
    }

    @Test
    public void testInvalidMobileNumber() {
        assertFalse(UserRegistration.isValidMobileNumber("9876543210"));
        assertFalse(UserRegistration.isValidMobileNumber("91 98765432"));
        assertFalse(UserRegistration.isValidMobileNumber("abc 9876543210"));
        assertFalse(UserRegistration.isValidMobileNumber("1 1234"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(UserRegistration.isValidPassword("password"));
        assertFalse(UserRegistration.isValidPassword("password123"));
        assertFalse(UserRegistration.isValidPassword("PASSWORD1"));
        assertFalse(UserRegistration.isValidPassword("password@"));
        assertFalse(UserRegistration.isValidPassword("Passw0rd"));
        assertFalse(UserRegistration.isValidPassword("Pass1234"));
        assertFalse(UserRegistration.isValidPassword("Pass1234!!!"));
    }


}