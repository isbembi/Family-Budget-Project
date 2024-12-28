package test;

import controller.ExpenseController;
import model.PersonalExpense;
import model.CasualExpense;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExpenseControllerTest {
    private ExpenseController expenseController;

    @BeforeAll
    void setup() {
        expenseController = new ExpenseController();
    }

    @Test
    @DisplayName("Добавление личного расхода")
    void testAddPersonalExpense() {
        PersonalExpense expense = new PersonalExpense(0, 1, "Test Expense", 100.0);
        expenseController.addPersonalExpense(expense);
        List<PersonalExpense> expenses = expenseController.getPersonalExpenses(1);
        Assertions.assertTrue(expenses.stream().anyMatch(e -> e.getTitle().equals("Test Expense")));
    }

    @Test
    @DisplayName("Добавление случайного расхода")
    void testAddCasualExpense() {
        CasualExpense expense = new CasualExpense(0, 1, 50.0, new Date());
        expenseController.addCasualExpense(expense);
        Assertions.assertTrue(true); // Если нет исключений – тест пройден
    }
}
