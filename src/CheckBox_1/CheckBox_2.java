package CheckBox_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CheckBox_2 extends Application {

    private Stage window;
    private Button button;
    private VBox layout;
    private Scene scene;
    private ChoiceBox<String> choiceBox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CheckBox_2");
        button = new Button("Click me");

        List<String> arrays = new ArrayList<>();
        arrays.add("A");
        arrays.add("B");
        arrays.add("C");
        arrays.add("D");

        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(arrays);

        choiceBox.setValue("B");
        choiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener( (v, olderValue, newValue)-> {
                    System.out.println(newValue);
                    System.out.println(olderValue);
                });

//        button.setOnAction(event -> getChoice());

        layout = new VBox(10);
//        layout.getChildren().addAll(choiceBox,button);
        layout.getChildren().addAll(choiceBox);
        layout.setPadding(new Insets(20,20,20,20));
        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

//    private void getChoice() {
//        System.out.println(this.choiceBox.getValue());
//    }
}














