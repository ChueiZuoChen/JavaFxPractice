package Alert;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class AlertBox {

    private static Label label;
    private static Stage window;
    private static Button button;
    private static Scene scene;

    public static void display(String title, String message) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        label = new Label(message);
        button = new Button("Close");
        button.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}























