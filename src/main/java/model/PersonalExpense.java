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

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public double getMonthlyAmountNeeded() { return monthlyAmountNeeded; }
}
