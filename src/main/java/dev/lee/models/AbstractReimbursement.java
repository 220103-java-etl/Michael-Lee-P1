package dev.lee.models;

import dev.lee.models.Status;
import dev.lee.models.User;

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
    private User author;
    private User resolver;
    private double amount;
    private String description;
    private Date date;
    private RType type;

    public AbstractReimbursement() {
        super();
    }

    public AbstractReimbursement(int id, Status status, User author, User resolver, double amount, String description, Date date,
    RType type) {
        super();
        this.id = id;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.type = type;
    }

    public Date getDate() {return date;}

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RType getType() {return type;}

    public void setType(RType type) {this.type = type;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && status == that.status && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, author, resolver, amount,description);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "id=" + id +
                ", status=" + status +
                ", author=" + author +
                ", resolver=" + resolver +
                ", amount=" + amount +
                ", description=" + description +
                ", date=" + date +
                '}';
    }
}

