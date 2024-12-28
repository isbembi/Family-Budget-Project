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

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getMonthlyAmountNeeded() { return monthlyAmountNeeded; }
    public void setMonthlyAmountNeeded(double monthlyAmountNeeded) { this.monthlyAmountNeeded = monthlyAmountNeeded; }
}
