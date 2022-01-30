package dev.lee.models;

public class User extends AbstractUser {

    // Instance Variables with Object Scope
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;
    private String location;

    // Constructors

    public User() {
    }

    public User(int id, String firstName, String lastName, String username, String password, Role role, String location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.location = location;
    }

    public User(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String firstName,String lastName, Role role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

    // Getters and Setter
/*
    public int getId() {
        return id;
    }

    public void setId(int i){}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { //should not be able to getPasswords from users(?)
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User --- id= " + this.id + "\nfirstName= " + this.firstName + " \nlastName= " + this.lastName +
                "\nusername= " + this.username + "\nrole= " + this.role + "\n";


    }
}
*/
