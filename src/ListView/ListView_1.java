package ListView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListView_1 extends Application {

    private Stage window;
    private Button button;
    private VBox layout;
    private Scene scene;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ListView_1");
        button = new Button("Click me");

        //
        listView = new ListView<>();
        listView.getItems().addAll("A","B","C","D","E","F","G","H","I");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //
        button.setOnAction(event -> buttonClicked());


        layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);

        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        String message = "";
        ObservableList<String> items;
        items = listView.getSelectionModel().getSelectedItems();

        for (String m :items) {
            message += m +"\n";
        }
        System.out.println(message);
    }
}
