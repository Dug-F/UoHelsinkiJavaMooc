package application;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

public class PartiesApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        Map<String, Map<Integer, Double>> allParties = new HashMap<String, Map<Integer, Double>>();
        
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        // populate data map from tsv file
        String filename = "partiesdata.tsv";
        try {
            List<String> headers = getHeaderData(filename);
            allParties = getResultsData(filename, headers);
        }
        catch (InvalidDataException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        } catch (Exception e) {
	    System.out.println("Error: " + e.getMessage());
        }
        
        populateChartData(allParties, lineChart);
        
        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
        
    }
    
    private List getHeaderData(String filename) throws InvalidDataException, Exception {
    Stream<String> lines = Files.lines(Paths.get(filename));    
    final List<String> headers = new ArrayList<>();

        // populate headers list from first line of file
        lines.findFirst().ifPresent(header -> {
            headers.addAll(Arrays.asList(header.split("\t")));
        });

        // validate that a header record exists
        if (headers.size() == 0 || !headers.get(0).equals("Party")) {
            throw new InvalidDataException("File does not contain a header record");
        }

        return headers;
    }
    
    private Map<String, Map<Integer, Double>> getResultsData(String filename, List<String> headers) throws InvalidDataException, Exception {
        Map<String, Map<Integer, Double>> resultsData = new HashMap<>();

        Stream<String> lines = Files.lines(Paths.get(filename));
        lines.skip(1).forEach(row -> {
            // for each data row
            try {
                Map<Integer, Double> values = new HashMap<>();
                
                // get row data fields
                String[] data = row.split("\t");

                if (data.length < 2) {
                    throw new InvalidDataException("Invalid row data found and ignored: " + data[0]);
                }
                // add each data field to values hashmap using corresponding header as key
                for (int i = 1; i < data.length; i++) {
                    // ignore the data field if it is -
                    if (data[i].contains("-")) {
                        continue;
                    }
                    values.put(Integer.valueOf(headers.get(i)), Double.valueOf(data[i]));
                }
                
                resultsData.put(data[0], values);
                
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
        
        return resultsData;
        
    }
    
    private void printMap(Map<String, Map<Integer, Double>> dataMap) {
        dataMap.keySet().stream().forEach(party -> {
            Map<Integer, Double> values = dataMap.get(party);
            System.out.println(party);
            values.keySet().stream().forEach(year -> {
                System.out.println(year + ": " + values.get(year));
            });
        });
    }
    
    private void populateChartData(Map<String, Map<Integer, Double>> dataMap, LineChart<Number, Number> lineChart) {
        // for each party
        dataMap.keySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add each set of values for this party to series
            dataMap.get(party).entrySet().stream().forEach(values -> {
                data.getData().add(new XYChart.Data(values.getKey(), values.getValue()));
            });

            // add series for this party to the chart
            lineChart.getData().add(data);
        });
    }
    
    public static void main(String[] args) {
        Application.launch(PartiesApplication.class);
        System.out.println("Hello world!");
    }

}
