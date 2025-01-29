package org.example;

import java.util.Scanner;


//i'm being time efficient!!!!!!!!!!!!! by using the same menu structure i used last time :3
public class SimpleBankingApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Inertia Banking ---");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Account.signIn();
                    break;
                case 2:
                    Account.signUp();
                    break;
                case 3:
                    System.out.println("Thank you, Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}
