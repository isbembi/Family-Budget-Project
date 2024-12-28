package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class ReportsPanel extends JFrame {

    public ReportsPanel() {
        setTitle("Financial Reports");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(300, "Expenses", "Food");
        dataset.addValue(200, "Expenses", "Transportation");
        dataset.addValue(150, "Expenses", "Internet");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Expenses",   // Заголовок диаграммы
                "Category",           // Ось X
                "Amount",             // Ось Y
                dataset               // Данные
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        add(chartPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ReportsPanel();
    }
}
