package dev.lee.models;

import java.sql.Date;


/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {

    public Reimbursement() {
        super();
    }


    public Reimbursement(int id, Status status, int authorId, int resolverId, double amount, String description, Date date, RType type, String message, GType grade) {
        super(id, status, authorId, resolverId, amount, description, date, type, message, grade);
    }
}
