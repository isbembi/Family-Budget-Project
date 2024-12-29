package utils;

import javax.swing.JOptionPane;

public class NotificationUtils {

    // Display an informational message
    public static void showInfoMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Display a warning message
    public static void showWarningMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    // Display an error message
    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Log notification to console
    public static void logNotification(String message) {
        System.out.println("Notification: " + message);
    }
}
