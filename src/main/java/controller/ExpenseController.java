package controller;

import model.PersonalExpense;
import model.CasualExpense;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    public void addPersonalExpense(PersonalExpense expense) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO personal_expense (user_id, title, monthly_amount_needed) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, expense.getUserId());
            stmt.setString(2, expense.getTitle());
            stmt.setDouble(3, expense.getMonthlyAmountNeeded());
            stmt.executeUpdate();
            System.out.println("✅ Личный расход успешно добавлен.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления личного расхода: " + e.getMessage());
        }
    }

    public void addCasualExpense(CasualExpense expense) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO casual_expense (user_id, amount_spent, date_spent) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, expense.getUserId());
            stmt.setDouble(2, expense.getAmountSpent());
            stmt.setDate(3, new Date(expense.getDateSpent().getTime()));
            stmt.executeUpdate();
            System.out.println("✅ Случайный расход успешно добавлен.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления случайного расхода: " + e.getMessage());
        }
    }

    public List<PersonalExpense> getPersonalExpenses(int userId) {
        List<PersonalExpense> expenses = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM personal_expense WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                expenses.add(new PersonalExpense(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getDouble("monthly_amount_needed")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения личных расходов: " + e.getMessage());
        }
        return expenses;
    }
}
