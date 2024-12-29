package model;

import java.util.Date;

public class CasualExpense {
    private int id;
    private int userId;
    private double amountSpent;
    private Date dateSpent;

    public CasualExpense(int id, int userId, double amountSpent, Date dateSpent) {
        this.id = id;
        this.userId = userId;
        this.amountSpent = amountSpent;
        this.dateSpent = dateSpent;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public double getAmountSpent() { return amountSpent; }
    public Date getDateSpent() { return dateSpent; }
}
