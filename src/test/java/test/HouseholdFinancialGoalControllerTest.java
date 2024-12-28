package test;

import controller.HouseholdFinancialGoalController;
import model.HouseholdFinancialGoal;
import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HouseholdFinancialGoalControllerTest {
    private HouseholdFinancialGoalController goalController;

    @BeforeAll
    void setup() {
        goalController = new HouseholdFinancialGoalController();
    }

    @Test
    @DisplayName("Добавление семейной цели")
    void testAddHouseholdGoal() {
        HouseholdFinancialGoal goal = new HouseholdFinancialGoal(0, "Test Goal", 1000.0, false);
        goalController.addHouseholdGoal(goal);
        List<HouseholdFinancialGoal> goals = goalController.getAllGoals();
        Assertions.assertTrue(goals.stream().anyMatch(g -> g.getTitle().equals("Test Goal")));
    }
}
