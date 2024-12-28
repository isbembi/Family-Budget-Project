package model;

public class UserFinances {
    private int userId;
    private double salary;
    private double personalExpenses;
    private double familyBudgetContribution;
    private double spareMoney;

    public UserFinances(int userId, double salary, double personalExpenses, double familyBudgetContribution, double spareMoney) {
        this.userId = userId;
        this.salary = salary;
        this.personalExpenses = personalExpenses;
        this.familyBudgetContribution = familyBudgetContribution;
        this.spareMoney = spareMoney;
    }

    // Геттеры и сеттеры
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public double getPersonalExpenses() { return personalExpenses; }
    public void setPersonalExpenses(double personalExpenses) { this.personalExpenses = personalExpenses; }

    public double getFamilyBudgetContribution() { return familyBudgetContribution; }
    public void setFamilyBudgetContribution(double familyBudgetContribution) { this.familyBudgetContribution = familyBudgetContribution; }

    public double getSpareMoney() { return spareMoney; }
    public void setSpareMoney(double spareMoney) { this.spareMoney = spareMoney; }
}
