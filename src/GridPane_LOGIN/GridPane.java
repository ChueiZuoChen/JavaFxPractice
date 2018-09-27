package GridPane_LOGIN;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class GridPane extends Application {

    private javafx.scene.layout.GridPane gridPane;
    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("hgfsdh");

        gridPane = new javafx.scene.layout.GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //nameLabel
        Label nameLabel = new Label("Username");
        javafx.scene.layout.GridPane.setConstraints(nameLabel,0,0);

        //nameInput
        TextField nameInput = new TextField("Paul");
        nameInput.setPromptText("username");
        javafx.scene.layout.GridPane.setConstraints(nameInput,1,0);

        //passwd
        Label passwdLabel = new Label("Password");
        javafx.scene.layout.GridPane.setConstraints(passwdLabel,0,1);

        //passwdInput
        TextField passwdInput = new TextField();
        passwdInput.setPromptText("password");
        javafx.scene.layout.GridPane.setConstraints(passwdInput,1,1);

        //loginButton
        Button loginButton = new Button("Login");
        javafx.scene.layout.GridPane.setConstraints(loginButton,1,2);


        gridPane.getChildren().addAll(nameLabel,nameInput,passwdLabel,passwdInput,loginButton);
        Scene scene = new Scene(gridPane,300,200);
        scene.getStylesheets().add("Viper.css");

        window.setScene(scene);
        window.show();

        System.out.println(nameInput.getText());
    }
}
