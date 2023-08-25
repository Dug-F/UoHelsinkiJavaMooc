package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {
        // create components to be used
        Button joke = new Button("Joke");
        Label jokeText = new Label("What do you call a bear with no teeth?");
        Button answer = new Button ("Answer");
        Label answerText = new Label("A gummy bear.");
        Button explanation = new Button("Explanation");
        Label explanationText = new Label("A bear with no teeth is gummy and a gummy bear is a sweet.");
        
        
        // create the menu layout
        HBox menu = new HBox();
        menu.setSpacing(10);
        menu.getChildren().addAll(joke, answer, explanation);
        
        // create the top level layout
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 180);
        layout.setTop(menu);
        layout.setCenter(jokeText);
        
        // set the button events
        
        joke.setOnAction((event) -> {
            layout.setCenter(jokeText);
        });
        
        answer.setOnAction((event) -> {
            layout.setCenter(answerText);
        });
        
        explanation.setOnAction((event) -> {
            layout.setCenter(explanationText);
        });
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(JokeApplication.class);
    }
}
