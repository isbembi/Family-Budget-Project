package model;

public class PersonalExpense {
    private int id;
    private int userId;
    private String title;
    private double monthlyAmountNeeded;

    public PersonalExpense(int id, int userId, String title, double monthlyAmountNeeded) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.monthlyAmountNeeded = monthlyAmountNeeded;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getMonthlyAmountNeeded() { return monthlyAmountNeeded; }
    public void setMonthlyAmountNeeded(double monthlyAmountNeeded) { this.monthlyAmountNeeded = monthlyAmountNeeded; }
}
