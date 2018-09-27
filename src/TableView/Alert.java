package TableView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Alert {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.setTitle(title);

        Label label = new Label(message);
        Button yesButton = new Button();
        yesButton.setFont(new Font("Yes",20));
        yesButton.setMinSize(150,60);
        yesButton.setOnAction(event -> window.close());

        VBox vlayout = new VBox(10);
        vlayout.setAlignment(Pos.CENTER);
        vlayout.getChildren().addAll(label,yesButton);
        vlayout.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(vlayout,300,250);
        window.setScene(scene);
        window.show();
    }
}
