package model;

public class HouseholdFinancialGoal {
    private int id;
    private String title;
    private double totalAmount;
    private boolean achieved;

    public HouseholdFinancialGoal(int id, String title, double totalAmount, boolean achieved) {
        this.id = id;
        this.title = title;
        this.totalAmount = totalAmount;
        this.achieved = achieved;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public boolean isAchieved() { return achieved; }
    public void setAchieved(boolean achieved) { this.achieved = achieved; }
}
