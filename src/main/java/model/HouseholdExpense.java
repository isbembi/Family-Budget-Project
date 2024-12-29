package model;

public class HouseholdExpense {
    private int id;
    private String title;
    private double monthlyAmountNeeded;

    public HouseholdExpense(int id, String title, double monthlyAmountNeeded) {
        this.id = id;
        this.title = title;
        this.monthlyAmountNeeded = monthlyAmountNeeded;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getMonthlyAmountNeeded() { return monthlyAmountNeeded; }
}
