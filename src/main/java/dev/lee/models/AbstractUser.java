package dev.lee.models;

import java.util.Objects;

public class AbstractUser {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;
    private String location;

    // Default Constructor
    public AbstractUser() {
        super();
    }

    //Full Constructor
    public AbstractUser(int id, String username, String password, Role role, String location) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.location = location;
    }

    //getter for first Name
    public String getFirstName() {
        return firstName;
    }

    //setter for first Name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter for last Name
    public String getLastName() {
        return lastName;
    }

    //setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getter for ID
    public int getId() {
        return id;
    }

    //setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // getter for Username
    public String getUsername() {
        return username;
    }

    //setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter for password
    public String getPassword() {
        return password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for role
    public Role getRole() {
        return role;
    }

    //setter for role
    public String setRole(Role role) {
        this.role = role; return role.toString();
    }

    public String getLocation() {return location;
    }

    public void setLocation(String location) {this.location = location;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUser that = (AbstractUser) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", location='" + location + '\'' +
                '}';
    }
}

