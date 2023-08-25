package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class GreeterApplication extends Application {

    @Override
    public void start (Stage window) {
        // 1.1 create components to be used in startLayout
        TextField name = new TextField();
        Button start = new Button ("Start");

        // 1.2 create startLayout and add components to it
        GridPane startLayout = new GridPane();
        startLayout.add(new Label("Enter your name and start."), 0, 1);
        startLayout.add(name, 0, 2);
        startLayout.add(start, 0, 3);
        Scene startScene = new Scene(startLayout);
        
        // 1.3 style the layout
        startLayout.setPrefSize(300, 180);
        startLayout.setVgap(10);
        startLayout.setHgap(10);
        startLayout.setPadding(new Insets(20, 20, 20, 20));
        
        // 2.1 create components to be used in welcomeLayout
        Label welcomeLabel = new Label("");
        
        // 2.2 create welcomeLayout and add components to it
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.getChildren().add(welcomeLabel);
        Scene welcomeScene = new Scene(welcomeLayout);
        
        //2.3 style welcomeLayout
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);
                
        start.setOnAction((event) -> {
            String nameEntered = name.getText();
            welcomeLabel.setText("Welcome " + nameEntered + "!");
            window.setScene(welcomeScene);
        });
        
        window.setScene(startScene);
        window.show();
        
    }

    public static void main(String[] args) {
        Application.launch(GreeterApplication.class);
    }

}
