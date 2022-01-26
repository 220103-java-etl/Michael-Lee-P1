package dev.lee.services;

import dev.lee.exceptions.UsernameNotUniqueException;
import dev.lee.models.User;
import dev.lee.repositories.UserDAO;

import java.util.Optional;




/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();

    //method to login
    public boolean login(String username, String password) {
        //first we need the help of the userDAO by username
        User u = UserDAO.getByUsername(username);

        //check if user exists
        if (u != null) {
            //check to make credentials match
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) ;
            return true;
        }
        System.out.println("Credentials do not match");//this would be a great place to use a custom exception.
        return false;
    }



    // * Should retrieve a User with the corresponding username or an empty optional if there is no match.

    public Optional<User> getByUsername(String username) throws UsernameNotUniqueException {

       User u = UserDAO.getByUsername(username);
       return Optional.ofNullable(u);
    }
}