package Alert;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfrimBox {

    private static Label label;
    private static Stage window;
    private static Button button;
    private static Scene scene;

    static boolean answer;

    public static boolean display(String title, String message) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        label = new Label(message);

        //create two button
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(event -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(event -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}

