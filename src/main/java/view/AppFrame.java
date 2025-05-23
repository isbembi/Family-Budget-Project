package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;


    public AppFrame() {
        // Настройки главного окна
        setTitle("Family Budget Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Инициализация CardLayout и основной панели
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Добавление панелей
        mainPanel.add(new LoginFramePanel(this), "Login");
        mainPanel.add(new PersonalDashboardPanel(this), "PersonalDashboard");
        mainPanel.add(new FamilyDashboardPanel(this), "FamilyDashboard");
        mainPanel.add(new ManagerDashboardPanel(this), "ManagerDashboard");
        mainPanel.add(new ChatPanelPanel(this), "ChatPanel");
        mainPanel.add(new ReportsPanelPanel(this), "ReportsPanel");

        // Добавление главной панели в окно
        add(mainPanel);

        // Отображение панели входа по умолчанию
        switchTo("Login");

        // Отображение главного окна
        setVisible(true);
    }

    /**
     * Метод для переключения между панелями.
     *
     * @param panelName Имя панели для отображения.
     */
    public void switchTo(String panelName) {
        cardLayout.show(mainPanel, panelName);
        System.out.println("🔄 Переключено на панель: " + panelName);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Установка системного стиля интерфейса
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("❌ Ошибка установки Look and Feel: " + e.getMessage());
            }

            // Запуск основного окна приложения
            new AppFrame();
            System.out.println("🚀 Приложение Family Budget Management успешно запущено!");
        });
    }
}
