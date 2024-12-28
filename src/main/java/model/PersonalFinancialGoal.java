package model;

public class PersonalFinancialGoal {
    private int id;
    private int userId;
    private double totalAmount;
    private String saveFrequency;
    private double oneSaveAmount;
    private boolean achieved;

    public PersonalFinancialGoal(int id, int userId, double totalAmount, String saveFrequency, double oneSaveAmount, boolean achieved) {
        this.id = id;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.saveFrequency = saveFrequency;
        this.oneSaveAmount = oneSaveAmount;
        this.achieved = achieved;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getSaveFrequency() { return saveFrequency; }
    public void setSaveFrequency(String saveFrequency) { this.saveFrequency = saveFrequency; }

    public double getOneSaveAmount() { return oneSaveAmount; }
    public void setOneSaveAmount(double oneSaveAmount) { this.oneSaveAmount = oneSaveAmount; }

    public boolean isAchieved() { return achieved; }
    public void setAchieved(boolean achieved) { this.achieved = achieved; }
}
