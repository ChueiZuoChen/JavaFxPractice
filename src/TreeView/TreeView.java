package TreeView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeView extends Application {

    private Stage window;
    private Button button;
    private VBox layout;
    private Scene scene;
    private javafx.scene.control.TreeView<String> treeView;
    private TreeItem<String> root;
    private TreeItem<String> firstlayer;
    private TreeItem<String> secondlayer;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView");
        button = new Button("Click me");

        //Tree Irem
        root = new TreeItem<>();


        //Root
        root.setExpanded(true);

        //firstLayer
        firstlayer = makeBranch("FirstLayer",root);
        makeBranch("A",firstlayer);
        makeBranch("B",firstlayer);
        makeBranch("C",firstlayer);

        //secondLayer
        secondlayer = makeBranch("FirstLayer",root);
        makeBranch("AA",secondlayer);
        makeBranch("BB",secondlayer);
        makeBranch("CC",secondlayer);
        makeBranch("DD",secondlayer);

        //create tree
        treeView = new javafx.scene.control.TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeView.getSelectionModel().selectedItemProperty()
                .addListener((v,oldValue,newValue)->{
                    if(newValue!=null){
                        System.out.println(newValue.getValue());
                    }

        });




        layout = new VBox(10);
        layout.getChildren().addAll(treeView);
        layout.setPadding(new Insets(20,20,20,20));
        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();



    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
