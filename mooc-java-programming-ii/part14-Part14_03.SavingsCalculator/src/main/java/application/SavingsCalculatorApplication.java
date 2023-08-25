package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class SavingsCalculatorApplication  extends Application {
    private LineChart<Number, Number> lineChart;
    private XYChart.Series principalSeries;
    private XYChart.Series totalSeries;
    private double currentMonthlySaving = 25;
    private double currentInterestRate = 0.0;
    
    @Override
    public void start(Stage stage) {
        
        BorderPane topLevelPane = new BorderPane();
        
        BorderPane savingsPane = setSavingsPane();
        BorderPane ratePane = setRatePane();
        
        // set controls pane
        VBox sliderLayout = new VBox(savingsPane, ratePane);
        sliderLayout.setSpacing(10);
        sliderLayout.setPadding(new Insets(20, 20, 20, 20));
        topLevelPane.setTop(sliderLayout);
        
        // set chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setAutoRanging(true);
        
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);
        
        principalSeries = new XYChart.Series();
        lineChart.getData().add(principalSeries);
        totalSeries = new XYChart.Series();
        lineChart.getData().add(totalSeries);
        updateChart(currentMonthlySaving, currentInterestRate);
        
        topLevelPane.setCenter(lineChart);
        
        Scene view = new Scene(topLevelPane);
        stage.setScene(view);
        stage.show();
        
    }
    
    private BorderPane setSavingsPane() {
        // set monthly savings slider pane
        BorderPane pane = new BorderPane();
        Slider slider = new Slider(25, 250, 5);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        Label setting = new Label(String.format("%.1f", currentMonthlySaving));
        pane.setLeft(new Label("Monthly savings"));
        pane.setCenter(slider);
        pane.setRight(setting);
        pane.setMargin(slider, new Insets(0, 20, 0, 20));
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> change, Number oldValue, Number newValue) {
                currentMonthlySaving = newValue.doubleValue();
                setting.setText(String.format("%.1f", currentMonthlySaving));
                updateChart(currentMonthlySaving, currentInterestRate);
            }
        });
        
        return pane;
    }
    
    private BorderPane setRatePane() {
        BorderPane pane = new BorderPane();
        Slider slider = new Slider(0, 10, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        Label setting = new Label(String.format("%.2f", currentInterestRate));
        pane.setLeft(new Label("Yearly interest rate"));
        pane.setCenter(slider);
        pane.setRight(setting);
        pane.setMargin(slider, new Insets(0, 20, 0, 20));
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> change, Number oldValue, Number newValue) {
                currentInterestRate = newValue.doubleValue();
                setting.setText(String.format("%.2f", currentInterestRate));
                updateChart(currentMonthlySaving, currentInterestRate);
            }
        });
        
        return pane;
    }
    
    private void updateChart(double monthlySavings, double interestRate) {
        principalSeries.getData().clear();
        totalSeries.getData().clear();
        
        double total = 0;
        for (int i = 0; i <= 30; i++) {
            principalSeries.getData().add(new XYChart.Data(i, monthlySavings * 12.0 * i));
            totalSeries.getData().add(new XYChart.Data(i, total));
            total = (total + monthlySavings * 12.0) * (1 + interestRate / 100.0);
        }
        
    }
    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
    
}
