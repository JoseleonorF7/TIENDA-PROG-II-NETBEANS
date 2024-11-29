package prueba.fx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ListaDeseosController implements Initializable {

    // FXML IDs para vincular con los elementos en tu archivo FXML
    @FXML
    private Button eliminarButton1;
    @FXML
    private Button agregarCarritoButton1;
    @FXML
    private Button eliminarButton2;
    @FXML
    private Button agregarCarritoButton2;

    @FXML
    private Text producto1;
    @FXML
    private Text precio1;
    @FXML
    private Text descripcion1;
    @FXML
    private Text disponibilidad1;
    @FXML
    private Text anadido1;

    @FXML
    private Text producto2;
    @FXML
    private Text precio2;
    @FXML
    private Text descripcion2;
    @FXML
    private Text disponibilidad2;
    @FXML
    private Text anadido2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aquí puedes inicializar datos o agregar listeners a los botones

        eliminarButton1.setOnAction(event -> eliminarProducto(1));
        agregarCarritoButton1.setOnAction(event -> agregarAlCarrito(1));

        eliminarButton2.setOnAction(event -> eliminarProducto(2));
        agregarCarritoButton2.setOnAction(event -> agregarAlCarrito(2));
    }

    // Métodos para manejar los eventos de los botones
    private void eliminarProducto(int productoId) {
        System.out.println("Eliminar producto " + productoId);
        // Lógica para eliminar un producto del sistema
    }

    private void agregarAlCarrito(int productoId) {
        System.out.println("Agregar al carrito producto " + productoId);
        // Lógica para agregar un producto al carrito
    }
}
