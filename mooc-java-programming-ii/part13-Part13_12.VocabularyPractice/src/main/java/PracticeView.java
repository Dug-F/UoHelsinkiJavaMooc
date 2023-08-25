package application;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PracticeView {
    private Dictionary dict;
    String randomWord;

    public PracticeView(Dictionary dict) {
        this.dict = dict;
        this.randomWord = this.dict.getRandomWord();
    }
    
    public Parent getView() {
        Label wordPrompt = new Label("Translate the word '" + this.randomWord + "'");
        TextField translation = new TextField();
        Button check = new Button("check");
        Label response = new Label();
        
        GridPane layout = new GridPane();
        layout.add(wordPrompt, 0, 1);
        layout.add(translation, 0, 2);
        layout.add(check, 0, 3);
        layout.add(response, 0, 4);
        
        layout.setVgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        check.setOnAction((event) -> {
            if (!translation.getText().equals(this.dict.get(this.randomWord))) {
                response.setText("Incorrect! The translation for the word '" + this.randomWord + "' is '" + this.dict.get(this.randomWord) + "'");
                return;
            }
            
            response.setText("Correct!");
            this.randomWord = this.dict.getRandomWord();
            wordPrompt.setText("Translate the word '" + this.randomWord + "'");
            translation.clear();
          
        });
        
        return layout;
    }
}
