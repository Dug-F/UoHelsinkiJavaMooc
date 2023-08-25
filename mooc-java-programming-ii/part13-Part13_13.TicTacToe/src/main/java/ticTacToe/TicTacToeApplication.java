package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TicTacToeApplication extends Application {
    private GameStatus status;

    @Override
    public void init() {
//        this.status = new GameStatus();
    }
    
    @Override
    public void start(Stage window) {
        this.status = new GameStatus();
        
        Parent layout = new Layout(this.status).getView();
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        
        
    }

    public static void main(String[] args) {
        Application.launch(TicTacToeApplication.class);
    }

}
