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
        FamilyChat message = new FamilyChat(0, 1, "Test Message", new Date());
        chatController.sendMessage(message);
        List<FamilyChat> messages = chatController.getAllMessages();
        Assertions.assertTrue(messages.stream().anyMatch(m -> m.getMessage().equals("Test Message")));
    }
}
