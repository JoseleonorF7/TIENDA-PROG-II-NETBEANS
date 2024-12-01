package prueba.fx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class for the main store interface
 */
public class InicioController implements Initializable {

    @FXML
    private Button btnProductos;
    @FXML
    private Button btnCarrito;
    @FXML
    private Button btnListaDeseos;
    @FXML
    private Button btnHistorial;
    @FXML
    private StackPane contentArea;
    @FXML
    private ImageView imgInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configureButtons();
    }

    private void configureButtons() {
        btnProductos.setOnAction(e -> loadView("productos.fxml"));
        btnCarrito.setOnAction(e -> loadView("carrito.fxml"));
        btnListaDeseos.setOnAction(e -> loadView("listaDeseos.fxml"));
        btnHistorial.setOnAction(e -> loadView("historial.fxml"));
    }

    private void loadView(String fxmlFile) {
        try {
            StackPane newView = javafx.fxml.FXMLLoader.load(getClass().getResource("/prueba/fx/Views/" + fxmlFile));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(newView);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
