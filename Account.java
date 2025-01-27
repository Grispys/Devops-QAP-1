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

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void deposit(double deposits){
        this.balance = this.balance + deposits;
        System.out.println("Deposit Successful. New Balance: " + this.balance);
    }

    public void withdraw(double withdrawal){
        if(withdrawal > this.balance){
            System.out.println("Withdrawal unsuccessful; Lack of funds. Your balance: $" + this.balance + ". Attempted Withdrawal: " + withdrawal);
        }else{
            this.balance = this.balance - withdrawal;
            System.out.println("Withdrawal Successful. New Balance: " + this.balance);
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

        Account tempUser = new Account(username, password);

        for(Account users : users){
            if(tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password)){
                System.out.println("Welcome, " + username);
            }
        }
    }



}
