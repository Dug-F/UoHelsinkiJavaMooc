package collage;

//import collage.Picture;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        int scaleFactor = 2;

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);
                Color negativeColor = new Color(1 - red, 1 - green, 1 - blue, opacity);

//                imageWriter.setColor(xCoordinate, yCoordinate, newColor);
                if (xCoordinate % scaleFactor == 0 && yCoordinate % scaleFactor == 0) {
                    for (int i = 0; i < scaleFactor; i++) {
                        for (int j = 0; j < scaleFactor; j++) {
                            int xPos = xCoordinate / scaleFactor + width / scaleFactor * i;
                            int yPos = yCoordinate / scaleFactor + height / scaleFactor * j;
                            imageWriter.setColor(xPos, yPos, negativeColor);
                        }
                    }
                }
                
                xCoordinate++;
            }

            yCoordinate++;
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);
        
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
