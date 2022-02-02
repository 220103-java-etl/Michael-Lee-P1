package dev.lee.app;
import dev.lee.models.User;
import dev.lee.repositories.UserDAO;
import dev.lee.services.UserService;
//import dev.lee.repositories.UserDAO;


import java.util.Scanner;

public class AppDriver {

    private static Scanner scan = new Scanner(System.in);



    //private static UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
       // UserService us = new UserService();
        //us.getByUsername("mlee9715");
        //Scanner pass
        System.out.println("Welcome to the Employee Reimbursement App!");
        System.out.println("Please choose an option to continue.");
        System.out.println("1. Login\n" +
                           "2. Register\n" +
                           "3. Quit");

        int input = scan.nextInt();

        switch (input) {
            case 1:
                scan.nextLine();
                System.out.println("You chose LOGIN");
                System.out.println("Please input your username:");
                String username = scan.nextLine();
                System.out.println("Please input your password:");
                String password = scan.nextLine();
                //System.out.println("Username entered = " + username); Manual test to make sure input is working
                //System.out.println("Password entered = " + password);
                //Insert exception check? let front end deal with? -> yep.
                // After gathering username and password we call upon a service class to call to the DB.

                break;
            case 2:
                scan.nextLine();
                System.out.println("You chose REGISTER.");
                System.out.println("Please input your FIRST name:");
                String firstName = scan.nextLine();
                System.out.println("Please input your LAST name:");
                String lastName = scan.nextLine();
                System.out.println("Create a new unique username:");
                //create conditional check here? username length? special characters? front end? -> yep?
                username = scan.nextLine();
                System.out.println("Create a unique and safe password:");
                password = scan.nextLine();
                break;
            case 3:
                System.out.println("You chose QUIT, goodbye.");
                break;
            default:
                System.out.println("Input not recognized please input an integer from the menu");

                // UserDAO pass
                //User[] users = userDAO.getAllUser();
                //System.out.println(Arrays.toString(users));

                //User u = UserDAO.getUser(3);
                //System.out.println(u);

                //User n = UserDAOold.createNewUser(1, "Michael", "Lee", "MDL", "pass");
                //System.out.println(n);
                //UserDAOold.deleteUser(1, "MDL", "pass");
        }
    }
}

