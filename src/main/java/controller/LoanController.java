package controller;

import model.Loan;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanController {

    public void addLoan(Loan loan) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO loan (user_id, total_amount, pay_frequency, one_pay_amount, paid_out) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, loan.getUserId());
            stmt.setDouble(2, loan.getTotalAmount());
            stmt.setString(3, loan.getPayFrequency());
            stmt.setDouble(4, loan.getOnePayAmount());
            stmt.setBoolean(5, loan.isPaidOut());
            stmt.executeUpdate();
            System.out.println("✅ Займ успешно добавлен.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления займа: " + e.getMessage());
        }
    }
}
