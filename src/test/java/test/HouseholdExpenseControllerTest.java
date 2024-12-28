package test;

import controller.HouseholdExpenseController;
import model.HouseholdExpense;
import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HouseholdExpenseControllerTest {
    private HouseholdExpenseController expenseController;

    @BeforeAll
    void setup() {
        expenseController = new HouseholdExpenseController();
    }

    @Test
    @DisplayName("Добавление семейного расхода")
    void testAddHouseholdExpense() {
        HouseholdExpense expense = new HouseholdExpense(
                0, "Electricity Bill", 120.00
        );
        expenseController.addHouseholdExpense(expense);
        Assertions.assertTrue(true); // Если нет исключений, тест пройден
    }

    @Test
    @DisplayName("Получение всех семейных расходов")
    void testGetAllHouseholdExpenses() {
        List<HouseholdExpense> expenses = expenseController.getAllHouseholdExpenses();
        Assertions.assertNotNull(expenses);
        Assertions.assertFalse(expenses.isEmpty(), "Список расходов не должен быть пустым");
    }

    @Test
    @DisplayName("Проверка содержания расхода")
    void testExpenseContent() {
        List<HouseholdExpense> expenses = expenseController.getAllHouseholdExpenses();
        HouseholdExpense firstExpense = expenses.get(0);
        Assertions.assertEquals("Electricity Bill", firstExpense.getTitle(), "Название расхода должно совпадать");
    }
}
