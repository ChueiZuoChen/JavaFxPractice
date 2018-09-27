package CheckBox_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("CheckBox_1.CheckBox Example");
        Button button = new Button("Click me");

        //CheckBox_1.CheckBox
        javafx.scene.control.CheckBox box1 = new javafx.scene.control.CheckBox("Bacon");
        box1.setSelected(true);
//        box1.setOnAction(event -> System.out.println("Bacon select"));

        javafx.scene.control.CheckBox box2 = new javafx.scene.control.CheckBox("Tuna");
//        box2.setOnAction(event -> System.out.println("Tuna select"));

        button.setOnAction(event -> handleOptions(box1,box2));
        VBox layout =new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(box1,box2,button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(javafx.scene.control.CheckBox box1, javafx.scene.control.CheckBox box2) {
        String message = "";
        if (box1.isSelected()){
            message += "bacon ";
        }
        if (box2.isSelected()){
            message += "tuna ";
        }
        System.out.println(message);
    }
}
