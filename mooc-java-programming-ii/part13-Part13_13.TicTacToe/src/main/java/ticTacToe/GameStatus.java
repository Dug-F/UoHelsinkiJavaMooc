package ticTacToe;

public class GameStatus {
    private String turn;
    private String[][] position;
    private boolean gameOver;
    
    public GameStatus() {
        this.turn = "X";
        this.gameOver = false;
        this.position = new String[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.position[row][col] = "";
            }
        }
    }
    
    public String getTurn() {
        return this.turn;
    }
    
    public void changeTurn() {
        if (this.turn.equals("X")) {
            this.turn = "O";
            return;
        }
        this.turn = "X";
    }
    
    public void setSquare(String player, int row, int col) {
        this.position[row][col] = player;
    }
    
    private boolean checkRows(String symbol, int row) {
        for (int col = 0; col < 3; col++) {
            if (!this.position[row][col].equals(symbol)) {
                return false;
            }
        }
        this.gameOver = true;
        return true;
    }
    
    private boolean checkCols(String symbol, int col) {
        for (int row = 0; row < 3; row++) {
            if (!this.position[row][col].equals(symbol)) {
                return false;
            }
        }
        this.gameOver = true;
        return true;
    }
    
    private boolean checkDownDiag(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (!this.position[i][i].equals(symbol)) {
                return false;
            }
        }
        this.gameOver = true;
        return true;
    }
    
    private boolean checkUpDiag(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (!this.position[2 - i][i].equals(symbol)) {
                return false;
            }
        }
        this.gameOver = true;
        return true;
    }
    
    public boolean checkGameOver(String symbol, int row, int col) {
        return this.checkRows(symbol, row) || this.checkCols(symbol, col) ||
                this.checkDownDiag(symbol) || this.checkUpDiag(symbol);
    }
    
    public boolean getGameOver() {
        return this.gameOver;
    }
}
