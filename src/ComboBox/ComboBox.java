package ComboBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBox extends Application {

    private Stage window;
    private VBox layout;
    private Scene scene;
    private Button button;
    private javafx.scene.control.ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ComboBox");
        button = new Button("Click me");

        //ComboBox
        comboBox = new javafx.scene.control.ComboBox<>();
        comboBox.getItems().addAll(
                "Good",
                "SC",
                "A"
        );

        comboBox.setPromptText("What is your favorite :");
        button.setOnAction(event -> printMovie());

        comboBox.setOnAction(event ->
                System.out.println("User selected: " + comboBox.getValue()));

        comboBox.setEditable(true);

        layout = new VBox();

        layout.getChildren().addAll(comboBox,button);
        layout.setPadding(new Insets(20,20,20,20));
        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();

    }

    private void printMovie() {
        System.out.println(this.comboBox.getValue());
    }
}
