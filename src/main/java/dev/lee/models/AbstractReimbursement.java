package dev.lee.models;

import java.util.Objects;
import java.util.Date;


/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 */
public class AbstractReimbursement {

    private int id;
    private Status status;
    private int authorId;
    private int resolverId;
    private double amount;
    private String description;
    private Date date;
    private RType type;
    private GType grade;
    private String message;

    public AbstractReimbursement() {
        super();
    }

    public AbstractReimbursement(int id, Status status, int authorId, int resolverId, double amount, String description, Date date,
    RType type, String message, GType grade) {
        super();
        this.id = id;
        this.status = status;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.type = type;
        this.grade = grade;
        this.message = message;
    }


    public java.sql.Date getDate() {return (java.sql.Date) date;}

    public void setDate(Date date) {this.date = date;}

    public String getDescription() { return description;  }

    public void setDescription(String description) { this.description = description;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public String setStatus(Status status) {
        this.status = status;
        return status.toString();
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolver(int resolverId) {this.resolverId = resolverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RType getType() {return type;}

    public void setType(RType type) {this.type = type;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public GType getGrade() {return grade;}

    public void setGrade(GType grade) {this.grade = grade;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && status == that.status && Objects.equals(authorId, that.authorId) && Objects.equals(resolverId, that.resolverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, authorId, resolverId, amount,description);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "id=" + id +
                ", status=" + status +
                ", authorId=" + authorId +
                ", resolverId=" + resolverId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}

