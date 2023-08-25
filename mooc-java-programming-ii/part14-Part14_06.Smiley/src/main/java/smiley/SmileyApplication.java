package smiley;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;


public class SmileyApplication extends Application {

    @Override
    public void start (Stage stage) {
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext context = canvas.getGraphicsContext2D();
        
        context.setFill(Color.BLACK);
        
        int width = 40;
        int height = 40;
        int eyeOffsetX = 220;
        int eyeOffsetY = 140;
        int mouthOffsetX = eyeOffsetX - width;
        int mouthOffsetY = eyeOffsetY + 140;
        
        context.fillRect(eyeOffsetX, eyeOffsetY, width, height);
        context.fillRect(640 - eyeOffsetX - width, eyeOffsetY, width, height);
        context.fillRect(mouthOffsetX, mouthOffsetY, width, height);
        context.fillRect(640 - mouthOffsetX - width, mouthOffsetY, width, height);
        for (int i = 1; i< 6; i++) {
            context.fillRect(mouthOffsetX + (width * i), mouthOffsetY + height, width, height);
        }
        
        BorderPane pane = new BorderPane();
        pane.setCenter(canvas);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
