package application;

import java.util.List;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class ShanghaiApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        //yAxis.setMinorTickCount(10);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        lineChart.setLegendVisible(false);
        
        List<String> seriesData = Arrays.asList(
            "2007 73",
            "2008 68",
            "2009 72",
            "2010 72",
            "2011 74",
            "2012 73",
            "2013 76",
            "2014 73",
            "2015 67",
            "2016 56",
            "2017 56"
        );
        
        // create series data entries
        XYChart.Series series = new XYChart.Series();
        series.setName("University of Helsinki");
        seriesData.stream().forEach(entry -> {
            String[] parts = entry.split(" ");
            series.getData().add(new XYChart.Data(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])));
        });
        
        // add the series data to the chart
        lineChart.getData().add(series);
        
        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        Application.launch(ShanghaiApplication.class);
    }

}
