package dev.lee.repositories;


import dev.lee.exceptions.*;
import dev.lee.models.*;
import dev.lee.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class ReimbursementDAO {
    static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    public Reimbursement create(Reimbursement reim_to_create) {
        String sql = "insert into reimbursements values(default, ?, ?, ?, ?, ?,?,?,?,?) returning *;";
        // insert questions marks and pass in parameters like getUsername
        try (Connection conn = cu.getConnection()) {// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, reim_to_create.getAmount());
            ps.setString(2, reim_to_create.getStatus().toString());
            ps.setInt(3, reim_to_create.getAuthorId());
            ps.setInt(4, 1);
            ps.setDate(5, reim_to_create.getDate());
            ps.setString(6, reim_to_create.getType().toString());
            ps.setString(7, reim_to_create.getGrade().toString());
            ps.setString(8, reim_to_create.getDescription());
            ps.setString(9, reim_to_create.getMessage());
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

        } catch (UsernameNotUniqueException | SQLException e) {
            e.printStackTrace();
        }
        return reim_to_create;
    }
    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public static List<Reimbursement> getById(int id) {//returns single reimbursement
        //return all users from the DB

        List<Reimbursement> reim = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from users u where user_id = ? AND left join reimbursements r on (u.id = r.author_id);";

        try (Connection conn = cu.getConnection()){// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement r = new Reimbursement(rs.getInt("reim_id"),Status.valueOf(rs.getString("reim_status")),rs.getInt("reim_author_id"),
                        rs.getInt("reim_resolver_id"), rs.getDouble("reim_cost"), rs.getString("reim_description"),
                        rs.getDate("reim_date"), RType.valueOf(rs.getString("reim_status")), rs.getString("reim_message"), GType.valueOf(rs.getString("reim_grade")));
                reim.add(r);
            }
            return reim;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
     // Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.

    public static List<Reimbursement> getByStatus(Status status) {
        List<Reimbursement> reim = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from reimbursements where reim_status = ?;";

        try (Connection conn = cu.getConnection()){// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status.toString());
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement r = new Reimbursement(rs.getInt("reim_id"),Status.valueOf(rs.getString("reim_status")),rs.getInt("reim_author_id"),
                        rs.getInt("reim_resolver_id"), rs.getDouble("reim_cost"), rs.getString("reim_description"),
                        rs.getDate("reim_date"), RType.valueOf(rs.getString("reim_status")), rs.getString("reim_message"), GType.valueOf(rs.getString("reim_grade")));
                reim.add(r);
            }
            return reim;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {

            String sql = "update users set reim_description = ?, reim_cost = ?, author_id = ?, reim_resolver = ?,reim_status = ?  where reim_id = ?";
            try (Connection conn = cu.getConnection()) {

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, unprocessedReimbursement.getDescription());
                ps.setDouble(2, unprocessedReimbursement.getAmount());
                ps.setInt(3, unprocessedReimbursement.getAuthorId());
                ps.setInt(4, unprocessedReimbursement.getResolverId());
                ps.setString(5, unprocessedReimbursement.getStatus().toString());
                ps.setInt(6, unprocessedReimbursement.getId());

                ps.executeUpdate();

            } catch (UpdateUnsuccessfulException | SQLException e) {
                e.printStackTrace();
            }
        return unprocessedReimbursement;
    }

    public static Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, int resolverId){
        String sql = "update reimbursements set reim_resolver_id = ?,reim_status = ?  where reim_id = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, resolverId);
            ps.setString(2, finalStatus.toString());
            ps.setInt(3, unprocessedReimbursement.getId());
            ps.executeUpdate();

        } catch (UpdateUnsuccessfulException | SQLException e) {
            e.printStackTrace();
        }
        return unprocessedReimbursement;
    }

    //Be able to delete a particular reimbursement if you give the reim ID.
    public void delete(Integer id) {
        String sql = "delete from reimbursements where reim_id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reimbursement addMessage(Reimbursement reim, String message) {
        String sql = "update from reimbursements set message = ? where reim_id = ?;";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, message);
            ps.setInt(2, reim.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reim;
    }
    public static List<Reimbursement> getAll() {
        //return all reim from the DB

        List<Reimbursement> reim = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from reimbursements;";

        try (Connection conn = cu.getConnection()){// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement r = new Reimbursement(rs.getInt("reim_id"),Status.valueOf(rs.getString("reim_status").toUpperCase(Locale.ROOT)),rs.getInt("reim_author_id"),
                        rs.getInt("reim_resolver_id"), rs.getDouble("reim_cost"), rs.getString("reim_description"),
                        rs.getDate("reim_date"), RType.valueOf(rs.getString("reim_type").toUpperCase(Locale.ROOT).replaceAll(" ","_")), rs.getString("reim_message"), GType.valueOf(rs.getString("reim_grade").toUpperCase(Locale.ROOT).replaceAll(" ","_")));
                reim.add(r);
            }
            return reim;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}

