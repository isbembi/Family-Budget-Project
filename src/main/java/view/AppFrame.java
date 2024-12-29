package view;

import javax.swing.*;
import java.awt.*;

/**
 * Главное окно приложения для управления Family Budget Management.
 * Использует CardLayout для переключения между различными панелями.
 */
public class AppFrame extends JFrame {
    private CardLayout cardLayout; // Макет для переключения панелей
    private JPanel mainPanel;
    private int currentUserId;

    public void setCurrentUserId(int userId) {
        this.currentUserId = userId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

// Основная панель с CardLayout

    public AppFrame() {
        // Настройка основного окна
        setTitle("Family Budget Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Инициализация CardLayout и главной панели
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Добавляем панели
        mainPanel.add(new LoginFramePanel(this), "Login");
        mainPanel.add(new PersonalDashboardPanel(this), "PersonalDashboard");
        mainPanel.add(new FamilyDashboardPanel(this), "FamilyDashboard");
        mainPanel.add(new ManagerDashboardPanel(this), "ManagerDashboard");
        mainPanel.add(new ChatPanelPanel(this, currentUserId), "ChatPanel");
        mainPanel.add(new ReportsPanelPanel(this), "ReportsPanel");

        // Добавляем главную панель в окно
        add(mainPanel);

        // Отображаем панель входа по умолчанию
        switchTo("Login");

        setVisible(true);
    }

    /**
     * Метод для переключения между панелями.
     *
     * @param panelName Имя панели для отображения.
     */
    public void switchTo(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppFrame::new);
    }
}
