package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class InvalidFirstNameException extends Exception {
    public InvalidFirstNameException(String message) {
        super(message);
    }
}

class InvalidLastNameException extends Exception {
    public InvalidLastNameException(String message) {
        super(message);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class UserRegistration {

    public static boolean isValidFirstName(String firstName) throws InvalidFirstNameException {
        if (!firstName.matches("[A-Z][a-zA-Z]{2,}")) {
            throw new InvalidFirstNameException("Invalid first name. It must start with a capital letter and be at least 3 characters long.");
        }
        return true;
    }

    public static boolean isValidLastName(String lastName) throws InvalidLastNameException {
        if (!lastName.matches("[A-Z][a-zA-Z]{2,}")) {
            throw new InvalidLastNameException("Invalid last name. It must start with a capital letter and be at least 3 characters long.");
        }
        return true;
    }

    public static boolean isValidEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid email. It must follow the format: abc.xyz@bl.co.in.");
        }
        return true;
    }

    public static boolean isValidMobileNumber(String mobileNumber) throws InvalidMobileNumberException {
        if (!mobileNumber.matches("^[0-9]{1,3} [0-9]{10}$")) {
            throw new InvalidMobileNumberException("Invalid mobile number. It must follow the format: <country code> <10-digit number>.");
        }
        return true;
    }

    public static boolean isValidPassword(String password) throws InvalidPasswordException {
        if (!(password.matches(".{8,}") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.replaceAll("[a-zA-Z0-9]", "").length() == 1)) {
            throw new InvalidPasswordException("Invalid password. It must be at least 8 characters long, contain at least one uppercase letter, one numeric digit, and exactly one special character.");
        }
        return true;
    }

    public static List<Boolean> validateEmailSamples(List<String> emails) {
        List<Boolean> results = new ArrayList<>();
        for (String email : emails) {
            try {
                results.add(isValidEmail(email));
            } catch (InvalidEmailException e) {
                results.add(false);
                System.out.println("Error validating email: " + email + " - " + e.getMessage());
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your first name:");
            String firstName = scanner.nextLine();
            isValidFirstName(firstName);
            System.out.println("First name is valid.");

            System.out.println("Enter your last name:");
            String lastName = scanner.nextLine();
            isValidLastName(lastName);
            System.out.println("Last name is valid.");

            System.out.println("Enter your email address:");
            String email = scanner.nextLine();
            isValidEmail(email);
            System.out.println("Email is valid.");

            System.out.println("Enter your mobile number:");
            String mobileNumber = scanner.nextLine();
            isValidMobileNumber(mobileNumber);
            System.out.println("Mobile number is valid.");

            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            isValidPassword(password);
            System.out.println("Password is valid.");
        } catch (InvalidFirstNameException | InvalidLastNameException | InvalidEmailException |
                 InvalidMobileNumberException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Validate a list of sample emails
        List<String> emailSamples = Arrays.asList(
                "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net",
                "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com",
                "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
                ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com",
                "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"
        );

        List<Boolean> results = validateEmailSamples(emailSamples);
        for (int i = 0; i < emailSamples.size(); i++) {
            System.out.println(emailSamples.get(i) + ": " + (results.get(i) ? "Valid" : "Invalid"));
        }
    }
}