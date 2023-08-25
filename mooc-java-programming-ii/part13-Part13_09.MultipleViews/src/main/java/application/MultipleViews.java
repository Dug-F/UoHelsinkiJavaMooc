package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) {
        BorderPane firstView = new BorderPane();
        firstView.setTop(new Label("First view!"));
        Button firstViewButton = new Button("To the second view!");
        firstView.setCenter(firstViewButton);
        Scene first = new Scene(firstView);
        
        VBox secondView = new VBox();
        secondView.setSpacing(10);
        Button secondViewButton = new Button("To the third view!");
        secondView.getChildren().add(secondViewButton);
        secondView.getChildren().add(new Label("Second view!"));
        Scene second = new Scene(secondView);
        
        GridPane thirdView = new GridPane();
        Button thirdViewButton = new Button("To the first view!");
        thirdView.add(new Label("Third view!"), 0, 0);
        thirdView.add(thirdViewButton, 1, 1);
        Scene third = new Scene(thirdView);
        
        firstViewButton.setOnAction((event) -> {
            window.setScene(second);
        });
        
        secondViewButton.setOnAction((event) -> {
            window.setScene(third);
        });
        
        thirdViewButton.setOnAction((event) -> {
            window.setScene(first);
        });
        
        window.setScene(first);
        window.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch(MultipleViews.class);
    }

}
