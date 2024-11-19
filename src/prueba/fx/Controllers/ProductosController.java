package prueba.fx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javafx.scene.layout.FlowPane;


public class ProductosController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private Button filterByPriceButton;
    @FXML
    private Button filterByPopularityButton;
    @FXML
    private FlowPane productPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del ComboBox de categorías
        categoryComboBox.setItems(FXCollections.observableArrayList("Electrónica", "Ropa", "Hogar"));

    }

}