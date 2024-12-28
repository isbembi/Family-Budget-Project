package controller;

import model.HouseholdExpense;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseholdExpenseController {

    public void addHouseholdExpense(HouseholdExpense expense) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO household_expense (title, monthly_amount_needed) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, expense.getTitle());
            stmt.setDouble(2, expense.getMonthlyAmountNeeded());
            stmt.executeUpdate();
            System.out.println("✅ Семейный расход добавлен.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления семейного расхода: " + e.getMessage());
        }
    }

    public List<HouseholdExpense> getAllHouseholdExpenses() {
        List<HouseholdExpense> expenses = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM household_expense";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                expenses.add(new HouseholdExpense(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("monthly_amount_needed")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения расходов: " + e.getMessage());
        }
        return expenses;
    }
}
