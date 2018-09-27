package TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableView extends Application {


    private Stage window;
    private VBox layout;
    private Scene scene;
    private javafx.scene.control.TableColumn <Product,String> nameColumn,priceColumn,quantityColumn;
    private javafx.scene.control.TableView<Product> tableView;
    private ObservableList<Product> products;
    private TextField nameInput;
    private TextField priceInput;
    private TextField quantityInput;
    private Button addButton;
    private Button deleteButton;
    private HBox hBox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("TableView");
        textField();
        tableView();

        addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());

        hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);



        layout = new VBox();
        layout.getChildren().addAll(tableView, hBox);

        scene = new Scene(layout,800,450);
        window.setScene(scene);

        window.show();

    }

    private void deleteButtonClicked() {
        ObservableList<Product> productSelected;
        productSelected = tableView.getSelectionModel().getSelectedItems();
        productSelected.forEach(tableView.getItems()::remove);

    }

    private void addButtonClicked() {
        Product product = new Product();
        if (priceInput.getText().equals("") && quantityInput.getText().equals("")) {
            Alert.display("Input Error","Enter Again");

        } else {
            product.setName(nameInput.getText());
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(quantityInput.getText()));
            tableView.getItems().add(product);
            nameInput.setText("");
            priceInput.setText("");
            quantityInput.setText("");
        }
    }

    private void textField() {
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);
    }

    private void tableView() {
        //nameColumn
        nameColumn = new javafx.scene.control.TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));

        //priceColumn
        priceColumn = new javafx.scene.control.TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        //quantityColumn
        quantityColumn = new javafx.scene.control.TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("quantity"));


        tableView = new javafx.scene.control.TableView<>();
        tableView.setItems(getProduct());
        tableView.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
    }

    //get all of the product
    public ObservableList<Product> getProduct(){
        products = FXCollections.observableArrayList();
        products.add(new Product("AA",10.1,101));
        products.add(new Product("BB",20.1,111));
        products.add(new Product("CC",30.1,121));
        products.add(new Product("DD",40.1,131));
        products.add(new Product("EE",50.1,141));
        products.add(new Product("FF",60.1,151));
        return products;

    }
}
