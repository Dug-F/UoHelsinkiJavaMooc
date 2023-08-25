package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        HBox labels = new HBox();
        labels.setSpacing(10);
        
        labels.getChildren().add(new Label("Letters: 0"));
        labels.getChildren().add(new Label("Words: 0"));
        labels.getChildren().add(new Label("The longest word is:"));
        
        BorderPane componentGroup = new BorderPane();
        componentGroup.setCenter(new TextArea());
        componentGroup.setBottom(labels);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
        
        
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
