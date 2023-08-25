package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



public class InputView {
    private Dictionary dict;
    
    public InputView(Dictionary dict) {
        this.dict = dict;
    }
    
    public Parent getView() {
        Label wordLabel = new Label("Word");
        TextField word = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translation = new TextField();
        Button add = new Button("Add the word pair");
        
        GridPane layout = new GridPane();
        layout.add(wordLabel, 0, 1);
        layout.add(word, 0, 2);
        layout.add(translationLabel, 0, 3);
        layout.add(translation, 0, 4);
        layout.add(add, 0, 5);
        
        layout.setVgap(10);
        layout.setPrefSize(300, 180);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        add.setOnAction((event) -> {
            this.dict.add(word.getText(), translation.getText());
            word.clear();
            translation.clear();
        });
        
        return layout;
    }
}
