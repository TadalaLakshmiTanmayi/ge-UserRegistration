package org.example;
import java.util.Scanner;
public class UserRegistration {
    public static boolean isValidFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
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
        scanner.close();
    }
}