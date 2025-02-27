package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Account> users = new ArrayList<>();
    public String username;
    public String password;
    public Double balance;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.balance = 0.00;
    }

    public void showBalance(){
        System.out.print("Your balance: $" + this.balance);
    }

    public double getBalance(){
        return this.balance;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void deposit(){
        System.out.println("Please enter amount to deposit: ");
        double deposits = scanner.nextDouble();
        if(deposits <=0){
            System.out.println("Error: cannot deposit zero");
        }else{
            depositAdd(deposits);
            System.out.println("Deposit Successful. New Balance: $" + this.balance);
        }

    }

    public void depositAdd(double money){
        this.balance += money;
    }

    public void withdraw(){
        System.out.println("Please enter amount to withdraw: ");
        double withdraw = scanner.nextDouble();
        withdrawalAdd(withdraw);

    }

    public boolean withdrawalAdd(double withdraw){
        if(withdraw > this.balance){
            System.out.println("Withdrawal unsuccessful; Lack of funds. Your balance: $" + this.balance + ". Attempted Withdrawal: " + withdraw);
            return false;
        }else{
            this.balance = this.balance - withdraw;
            System.out.println("Withdrawal Successful. New Balance: $" + this.balance);
            return true;
        }
    }


    public static void signUp(){
        System.out.println("Please enter your username: ");
        String name = scanner.nextLine();
        System.out.println("Please your password: ");
        String pass= scanner.nextLine();
        System.out.println("Account successfully Created");
        Account user = new Account(name, pass);
        users.add(user);
    }

    public static void signIn(){
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

//        System.out.println(users);

        for(Account user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
//                user.deposit(200.00);
                System.out.println("Welcome, " + username);
                while (true) {
                    System.out.println("\n--- Inertia Banking ---");
                    System.out.println("1. Make a Deposit");
                    System.out.println("2. Make a Withdrawal");
                    System.out.println("3. View Balance");
                    System.out.println("4. Sign out");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            user.deposit();
                            break;
                        case 2:
                            user.withdraw();
                            break;
                        case 3:
                            user.showBalance();
                            break;
                        case 4:
                            System.out.println("Logging out...");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }else{
                System.out.println("Error: Invalid credentials");
            }
        }
    }



}
