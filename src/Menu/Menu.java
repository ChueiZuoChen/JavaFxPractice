package Menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application {


    private Stage window;
    private BorderPane layout;
    private Scene scene;
    private javafx.scene.control.Menu fileMenu;
    private javafx.scene.control.Menu editMenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu");

        //fileMenu
        fileMenu = new javafx.scene.control.Menu("File");

        //Menu Item
        MenuItem newFile = new javafx.scene.control.MenuItem("_New...");
        newFile.setOnAction(event -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new javafx.scene.control.Menu("_Open..."));
        fileMenu.getItems().add(new javafx.scene.control.Menu("_Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new javafx.scene.control.Menu("_Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new javafx.scene.control.Menu("_Exit..."));

        //Edit menu
        editMenu = new javafx.scene.control.Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem pasteMenu = new javafx.scene.control.MenuItem("Paste");
        pasteMenu.setOnAction(event -> System.out.println("Pasting some crap"));
        pasteMenu.setDisable(true);
        editMenu.getItems().add(pasteMenu);

        //Help menu
        javafx.scene.control.Menu helpMenu = new javafx.scene.control.Menu("Help");
        CheckMenuItem showLine = new CheckMenuItem("Show Line Numbers");
        showLine.setOnAction(event -> {
            if (showLine.isSelected()){
                System.out.println("Program will now display line numbers.");
            } else {
                System.out.println("Giding line number");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLine,autoSave);

        //RadioMenuItems
        javafx.scene.control.Menu diff = new javafx.scene.control.Menu("Difficulty");
        ToggleGroup diffToggole = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem mediun = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(diffToggole);
        mediun.setToggleGroup(diffToggole);
        hard.setToggleGroup(diffToggole);

        diff.getItems().addAll(easy,mediun,hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu,diff);

        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.getChildren().addAll();
        scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
