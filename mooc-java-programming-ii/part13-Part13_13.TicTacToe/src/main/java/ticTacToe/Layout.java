package ticTacToe;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Layout {
    private GameStatus status = new GameStatus();
    
    public Layout(GameStatus status) {
        this.status = status;
    }
    
    public Parent getView() {
        BorderPane layout = new BorderPane();
        
        Label turn = new Label("Turn: X");
        turn.setFont(Font.font("Monospaced", 40));
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);
        
        for (int row = 0; row <= 2; row++) {
            for (int col = 0; col <= 2; col++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                grid.add(button, col, row);
                final int squareRow = row;
                final int squareCol = col;
                
                button.setOnAction((event) -> {
                    if (!button.getText().equals(" ") || this.status.getGameOver()) {
                        return;
                    }
                    String currentTurn = this.status.getTurn();
                    button.setText(currentTurn);
                    
                    this.status.setSquare(currentTurn, squareRow, squareCol);
                    if (this.status.checkGameOver(currentTurn, squareRow, squareCol)) {
                        turn.setText("The end!");
                        return;
                    }
                    this.status.changeTurn();
                    turn.setText("Turn: " + this.status.getTurn());
                });
            }
        }
        
        layout.setTop(turn);
        layout.setCenter(grid);
            
        return layout;
    }
   
}