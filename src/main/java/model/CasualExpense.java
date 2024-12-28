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

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmountSpent() { return amountSpent; }
    public void setAmountSpent(double amountSpent) { this.amountSpent = amountSpent; }

    public Date getDateSpent() { return dateSpent; }
    public void setDateSpent(Date dateSpent) { this.dateSpent = dateSpent; }
}
