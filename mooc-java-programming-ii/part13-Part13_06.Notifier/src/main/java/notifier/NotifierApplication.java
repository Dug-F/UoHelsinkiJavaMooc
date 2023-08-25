package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public void start (Stage window) {
        TextField topText = new TextField();
        Button button = new Button("Update");
        Label bottomText = new Label();
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().add(topText);
        vbox.getChildren().add(button);
        vbox.getChildren().add(bottomText);
        
        button.setOnAction((event) -> {
            bottomText.setText(topText.getText());
//            Label textElement = (Label) vbox.getChildren().get(2);
//            System.out.println("Text: " + textElement.getText());
        });
        
        Scene view = new Scene(vbox);
        
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
