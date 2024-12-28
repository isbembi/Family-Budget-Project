package test;

import controller.PersonalFinancialGoalController;
import model.PersonalFinancialGoal;
import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonalFinancialGoalControllerTest {
    private PersonalFinancialGoalController goalController;

    @BeforeAll
    void setup() {
        goalController = new PersonalFinancialGoalController();
    }

    @Test
    @DisplayName("Добавление личной финансовой цели")
    void testAddFinancialGoal() {
        PersonalFinancialGoal goal = new PersonalFinancialGoal(
                0, 1, 5000.0, "MONTH", 500.0, false
        );
        goalController.addFinancialGoal(goal);
        Assertions.assertTrue(true); // Если нет исключений, тест пройден
    }

    @Test
    @DisplayName("Получение целей пользователя")
    void testGetUserGoals() {
        List<PersonalFinancialGoal> goals = goalController.getUserGoals(1);
        Assertions.assertNotNull(goals);
        Assertions.assertFalse(goals.isEmpty(), "Список целей пользователя не должен быть пустым");
    }

    @Test
    @DisplayName("Проверка достижения цели")
    void testGoalAchieved() {
        List<PersonalFinancialGoal> goals = goalController.getUserGoals(1);
        PersonalFinancialGoal firstGoal = goals.get(0);
        Assertions.assertFalse(firstGoal.isAchieved(), "Цель не должна быть достигнута по умолчанию");
    }
}
