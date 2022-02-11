package dev.lee.services;

import dev.lee.models.Reimbursement;
import dev.lee.models.Role;
import dev.lee.models.Status;
import dev.lee.models.User;
import dev.lee.repositories.ReimbursementDAO;
import dev.lee.repositories.UserDAO;

import java.util.Collections;
import java.util.List;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {
       private  ReimbursementDAO reimbursementDAO = new ReimbursementDAO();

    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
     */

    public static Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, int resolverId) {
        ReimbursementDAO.process(unprocessedReimbursement, finalStatus, resolverId);
        return unprocessedReimbursement;
    }
    public Reimbursement createReimbursement(Reimbursement newReim){
        reimbursementDAO.create(newReim);
        return newReim;
    }

    /**
     * Should retrieve all reimbursements with the correct status.
     */
    public List<Reimbursement> getReimbursementsByStatus(Status status) {
        List<Reimbursement> r = ReimbursementDAO.getByStatus(status);
        return r;
    }
    public static List<Reimbursement> getReimbursementsById(int id) {
        List<Reimbursement> r = ReimbursementDAO.getById(id);
        return r;
    }


public Reimbursement addMessage(Reimbursement reim ,String message){
    reim.setMessage(message);
    return reim;
}
public static List<Reimbursement> getAll(){
        return ReimbursementDAO.getAll();
    }
}