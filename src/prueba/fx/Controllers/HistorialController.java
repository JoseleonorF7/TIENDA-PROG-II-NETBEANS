package prueba.fx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class HistorialController implements Initializable {

    // Botones de "Hoy"
    @FXML
    private Button detallesHoy1;
    @FXML
    private Button agregarCarritoHoy1;
    @FXML
    private Button detallesHoy2;
    @FXML
    private Button agregarCarritoHoy2;

    // Botones de "Ayer"
    @FXML
    private Button detallesAyer1;
    @FXML
    private Button agregarCarritoAyer1;
    @FXML
    private Button detallesAyer2;
    @FXML
    private Button agregarCarritoAyer2;

    // Paneles
    @FXML
    private Pane paneHoy1;
    @FXML
    private Pane paneHoy2;
    @FXML
    private Pane paneAyer1;
    @FXML
    private Pane paneAyer2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aquí puedes inicializar cualquier lógica necesaria
        setupButtonActions();
    }

    /**
     * Configura las acciones de los botones.
     */
    private void setupButtonActions() {
        // Acciones para los botones de "Hoy"
        detallesHoy1.setOnAction(e -> mostrarDetalles("Hoy 1"));
        agregarCarritoHoy1.setOnAction(e -> agregarCarrito("Hoy 1"));
        detallesHoy2.setOnAction(e -> mostrarDetalles("Hoy 2"));
        agregarCarritoHoy2.setOnAction(e -> agregarCarrito("Hoy 2"));

        // Acciones para los botones de "Ayer"
        detallesAyer1.setOnAction(e -> mostrarDetalles("Ayer 1"));
        agregarCarritoAyer1.setOnAction(e -> agregarCarrito("Ayer 1"));
        detallesAyer2.setOnAction(e -> mostrarDetalles("Ayer 2"));
        agregarCarritoAyer2.setOnAction(e -> agregarCarrito("Ayer 2"));
    }

    /**
     * Muestra los detalles de un producto.
     *
     * @param categoria La categoría (ej. "Hoy", "Ayer").
     */
    private void mostrarDetalles(String categoria) {
        System.out.println("Mostrando detalles de: " + categoria);
        // Aquí puedes agregar la lógica para mostrar detalles
    }

    /**
     * Agrega un producto al carrito.
     *
     * @param categoria La categoría (ej. "Hoy", "Ayer").
     */
    private void agregarCarrito(String categoria) {
        System.out.println("Agregando al carrito desde: " + categoria);
        // Aquí puedes agregar la lógica para agregar al carrito
    }
}
