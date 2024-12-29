package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
public class ReportsPanelPanel extends JPanel {
    public ReportsPanelPanel(AppFrame appFrame) {
        setLayout(new BorderLayout());


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(300, "Expenses", "Food");
        dataset.addValue(200, "Expenses", "Transportation");
        dataset.addValue(150, "Expenses", "Internet");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Expenses",
                "Category",
                "Amount",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        add(chartPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> appFrame.switchTo("PersonalDashboard"));
        add(backButton, BorderLayout.SOUTH);
    }
}
