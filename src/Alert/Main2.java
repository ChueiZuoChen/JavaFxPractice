package Alert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main2 extends Application {

    private Stage window;
    private Button button;
    private StackPane layout;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("wwww");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeprogram();
        });

        button = new Button("Click me");
        button.setOnAction(event -> closeprogram());

        layout = new StackPane();
        layout.getChildren().add(button);
        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void closeprogram() {
        boolean isCloseed = ConfrimBox.display("Title", "Sure you want to exit?");
        if (isCloseed)
            window.close();
    }
}




