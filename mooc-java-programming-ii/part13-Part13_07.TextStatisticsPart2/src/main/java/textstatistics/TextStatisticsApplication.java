package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        HBox labels = new HBox();
        labels.setSpacing(10);
        
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestLabel = new Label("The longest word is: ");
        
        labels.getChildren().add(lettersLabel);
        labels.getChildren().add(wordsLabel);
        labels.getChildren().add(longestLabel);
        
        TextArea textArea = new TextArea();
        
        BorderPane componentGroup = new BorderPane();
        componentGroup.setCenter(textArea);
        componentGroup.setBottom(labels);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int letters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            lettersLabel.setText("Letters: " + letters);
            wordsLabel.setText("Words: " + words);
            longestLabel.setText("The longest word is: " + longest);
        });
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
        
        
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
