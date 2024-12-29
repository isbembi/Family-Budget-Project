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

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public double getTotalAmount() { return totalAmount; }
    public String getPayFrequency() { return payFrequency; }
    public double getOnePayAmount() { return onePayAmount; }
    public boolean isPaidOut() { return paidOut; }
}
