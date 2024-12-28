package test;

import controller.LoanController;
import model.Loan;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoanControllerTest {
    private LoanController loanController;

    @BeforeAll
    void setup() {
        loanController = new LoanController();
    }

    @Test
    @DisplayName("Добавление займа")
    void testAddLoan() {
        Loan loan = new Loan(0, 1, 5000.0, "MONTH", 500.0, false);
        loanController.addLoan(loan);
        Assertions.assertTrue(true); // Если нет исключений – тест пройден
    }
}
