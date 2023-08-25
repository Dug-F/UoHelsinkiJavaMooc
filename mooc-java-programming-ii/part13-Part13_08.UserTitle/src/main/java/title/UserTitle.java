package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;


public class UserTitle extends Application {
    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String title = params.getNamed().get("title");
        
//        FlowPane componentGroup = new FlowPane();
//        componentGroup.getChildren().add(new Button("Button"));
//        Scene view = new Scene(componentGroup);
        
//        window.setScene(view);
        window.setTitle(title);
        window.show();
        
    }

}
