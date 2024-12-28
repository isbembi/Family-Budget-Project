package model;

public class Loan {
    private int id;
    private int userId;
    private double totalAmount;
    private String payFrequency;
    private double onePayAmount;
    private boolean paidOut;

    public Loan(int id, int userId, double totalAmount, String payFrequency, double onePayAmount, boolean paidOut) {
        this.id = id;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.payFrequency = payFrequency;
        this.onePayAmount = onePayAmount;
        this.paidOut = paidOut;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getPayFrequency() { return payFrequency; }
    public void setPayFrequency(String payFrequency) { this.payFrequency = payFrequency; }

    public double getOnePayAmount() { return onePayAmount; }
    public void setOnePayAmount(double onePayAmount) { this.onePayAmount = onePayAmount; }

    public boolean isPaidOut() { return paidOut; }
    public void setPaidOut(boolean paidOut) { this.paidOut = paidOut; }
}
