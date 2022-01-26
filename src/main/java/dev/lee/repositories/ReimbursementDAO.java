package dev.lee.repositories;


import dev.lee.models.Reimbursement;
import dev.lee.models.Status;
import dev.lee.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class ReimbursementDAO {
    static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public List<Reimbursement> getById(int id) {//returns single reimbursement
        //return all users from the DB

        List<Reimbursement> reim = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from u where user_id = ? AND left join reimbursements r on (u.id = r.author_id);";

        try (Connection conn = cu.getConnection()){// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement r = new Reimbursement();
                rs.getInt("user_id");
                rs.getInt("reim_id");
                rs.getDouble("reim_cost");
                rs.getString("reim_description");
                rs.getString("reim_status");
                //add address/location


                reim.add(r);
            }
            return reim;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
     // Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.

    public List<Reimbursement> getByStatus(Status status) {
        List<Reimbursement> reim = new ArrayList<>();
        //this is our sql statement -> we want it to return all records from the table
        String sql = "select * from reimbursements where reim_status =" + status+";";

        try (Connection conn = cu.getConnection()){// proper syntax for try with resources used to automatically
            // close resources after the try/catch/finally block

            //Prepare the Statement(Inside try block)
            PreparedStatement ps = conn.prepareStatement(sql);

            //Execute the statement and save the Result Set into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement r = new Reimbursement();
                rs.getInt("user_id");
                rs.getInt("reim_id");
                rs.getString("reim_status");
               // rs.getString("reim_description"); do I need to add all or just the ones I need?
               // rs.getString("reim_status");


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
        return null;
    }


}

