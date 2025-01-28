import java.util.*;
import java.util.LinkedList;
class Account{
    String username;
    String pswd;
    Account(String username){
        this.username = username;
    }
}
public class LoginManagementSystem {
    public static LinkedList<Account> l = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void menu(){
        while (true) {
            System.out.println("1. Login\n2. Register\n3. Exit");
            String c = sc.next();
            if (c.equals("1")) {
                boolean a = login();
                if(!a){
                    break;
                }
            } 
            else if (c.equals("2")) {
                boolean b = register();
                if(!b){
                    break;
                }
            } 
            else if (c.equals("3")) {
                System.out.println("Thank You");
                break;
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static boolean login(){
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String pswd = sc.next();
        for (Account account : l) {
            if(account.username.equals(username) && (account.pswd!=null?account.pswd.equals(pswd):false)){
                System.out.println("Login successful");
                return logout();
            }
        }
        System.out.println("Invalid credentials");
        return true;
    }
    public static boolean logout(){
        System.out.print("Do you want to logout (y/n): ");
        char s =  sc.next().charAt(0);
        if(s == 'y'){
            System.out.println("You have logged out");
            return true;
        }
        return false;
    }
    public static boolean register(){
        System.out.print("Create username: ");
        String username = sc.next();
        Account s = new Account(username);
        System.out.print("Create Password: ");
        String pswd = sc.next();
        for(Account account : l) {
            if(account.username.equals(username)){
                System.out.println("Already registered");
                return true;
            }
        }
        l.add(s);
        s.pswd = pswd;
        System.out.println("Registered successfully");
        return logout();
    }
    public static void main(String[] args){
        menu();
    }
}