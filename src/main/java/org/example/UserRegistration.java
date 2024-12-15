package org.example;
import java.util.Scanner;

public class UserRegistration {

    public static boolean isValidFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public static boolean isValidLastName(String lastName) {
        return lastName.matches("[A-Z][a-zA-Z]{2,}");
    }
    public static boolean isValidEmail(String email) {
        // Regular expression to validate the email
        String emailRegex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";

        // Return whether the email matches the regex
        return email.matches(emailRegex);
    }
    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("^[0-9]{1,3} [0-9]{10}$");
    }
    public static boolean isValidPassword(String password) {
        return password.matches(".{8,}")  && password.matches(".*[A-Z].*");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        if (isValidFirstName(firstName)) {
            System.out.println("First name is valid.");
        } else {
            System.out.println("Invalid first name. It must start with a capital letter and be at least 3 characters long.");
        }

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        if (isValidLastName(lastName)) {
            System.out.println("Last name is valid.");
        } else {
            System.out.println("Invalid last name. It must start with a capital letter and be at least 3 characters long.");
        }
        System.out.println("Enter your email address:");
        String email = scanner.nextLine();

        if (isValidEmail(email)) {
            System.out.println("Email is valid.");
        } else {
            System.out.println("Invalid email. It must follow the format: abc.xyz@bl.co.in.");
        }

        System.out.println("Enter your mobile number:");
        String mobileNumber = scanner.nextLine();

        if (isValidMobileNumber(mobileNumber)) {
            System.out.println("Mobile number is valid.");
        } else {
            System.out.println("Invalid mobile number. It must follow the format: <country code> <10-digit number>.");
        }

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Invalid password. It must be at least 8 characters long and contain at least one uppercase letter.");
        }


        scanner.close();
    }
}