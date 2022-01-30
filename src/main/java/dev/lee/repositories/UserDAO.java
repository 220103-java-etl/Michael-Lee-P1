package dev.lee.repositories;

import dev.lee.exceptions.UsernameNotUniqueException;
import dev.lee.models.Role;
import dev.lee.models.User;
import dev.lee.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dev.lee.models.Role.EMPLOYEE;
import static dev.lee.models.Role.FINANCE_MANAGER;


public class UserDAO  {

    static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public static User getByUsername(String username) {
        String sql = "select * from users where username =?;";

        try (Connection conn = cu.getConnection()) {// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            User u = null;
            while (rs.next()) {
                u = new User();
                rs.getInt("user_id");
                rs.getString("username");
                rs.getString("first_name");
                rs.getString("last_name");
                rs.getString("role");
                rs.getString("password");
            }
            return u;
        } catch (UsernameNotUniqueException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAll() {
        //return all users from the DB

        List<User> users = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from users";

        try (Connection conn = cu.getConnection()) {// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);

            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                rs.getInt("user_id");
                rs.getString("first_name");
                rs.getString("last_name");
                rs.getString("role");
                rs.getString("password");
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User create(User employee_to_register) {
        String sql = "insert into users values(default, ?, ?, ?, ?, ?,?);";
        // insert questions marks and apss in paramters like getUsername
        try (Connection conn = cu.getConnection()) {// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee_to_register.getFirstName());
            ps.setString(2, employee_to_register.getLastName());
            ps.setString(3, employee_to_register.getUsername());
            ps.setString(4, employee_to_register.getPassword());
            ps.setString(5, employee_to_register.getRole().toString());
            ps.setString(6, employee_to_register.getLocation());
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

        } catch (UsernameNotUniqueException | SQLException e) {
            e.printStackTrace();
        }
        return employee_to_register;
    }

    public User createManager(User manager_to_register) {
        String sql = "insert into users values(default, ?, ?, ?, ?, ?,?);";
        // insert questions marks and apss in parameters like getUsername
        try (Connection conn = cu.getConnection()) {// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager_to_register.getFirstName());
            ps.setString(2, manager_to_register.getLastName());
            ps.setString(3, manager_to_register.getUsername());
            ps.setString(4, manager_to_register.getPassword());
            ps.setString(5, manager_to_register.setRole(Role.valueOf(FINANCE_MANAGER.toString())));
            ps.setString(6, manager_to_register.getLocation());
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

        } catch (UsernameNotUniqueException | SQLException e) {
            e.printStackTrace();
        }
        return manager_to_register;
    }


    public void update(User user) {
        String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ?,role = ?, location = ?  where id = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole().toString());
            ps.setString(6, user.getLocation());
            ps.setInt(7, user.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(Integer id) {
       String sql = "delete from users where id = ?";

       try (Connection conn = cu.getConnection()) {
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
