package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dict;
    
    @Override
    public void init() throws Exception {
        this.dict = new Dictionary();      
    }
    
    @Override
    public void start(Stage window) {
        InputView inputView = new InputView(this.dict);
        PracticeView practiceView = new PracticeView(this.dict);
        Parent addPane = inputView.getView();
        Parent practicePane = practiceView.getView();
        
        Button add = new Button("Enter new words");
        Button practice = new Button("Practice");
        HBox menu = new HBox();
        menu.setSpacing(10);
        
        menu.getChildren().addAll(add, practice);
        
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 180);
        layout.setTop(menu);
        layout.setCenter(addPane);
        
        add.setOnAction((event) -> {
            layout.setCenter(addPane);
        });
        practice.setOnAction((event) -> {
            layout.setCenter(practicePane);
        });
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }

    public static void main(String[] args) {
        Application.launch(VocabularyPracticeApplication.class);
    }
}
