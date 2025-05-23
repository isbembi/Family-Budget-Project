package test;

import controller.FamilyChatController;
import model.FamilyChat;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FamilyChatControllerTest {
    private FamilyChatController chatController;

    @BeforeAll
    void setup() {
        chatController = new FamilyChatController();
    }

    @Test
    @DisplayName("Отправка сообщения в чат")
    void testSendMessage() {
        chatController.sendMessage("Hello, Chat!");
        List<FamilyChat> messages = chatController.getAllMessagesWithUserNames();
        Assertions.assertTrue(
                messages.stream().anyMatch(
                        m -> m.getMessage().equals("Hello, Chat!") && m.getUserName().equals("TestUser")
                ),
                "Сообщение должно отображаться с корректным именем пользователя"
        );
    }
}
