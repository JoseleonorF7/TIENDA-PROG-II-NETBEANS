package prueba.fx.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class CarritoController implements Initializable {

    // Ejemplo de referencias a los componentes en el FXML
    @FXML
    private Button btnSacarDelCarrito1;
    @FXML
    private Button btnComprar1;
    @FXML
    private Button btnSacarDelCarrito2;
    @FXML
    private Button btnComprar2;

    @FXML
    private Text producto1;
    @FXML
    private Text precio1;
    @FXML
    private Text producto2;
    @FXML
    private Text precio2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar acciones para los botones
        btnSacarDelCarrito1.setOnAction(event -> sacarDelCarrito(1));
        btnComprar1.setOnAction(event -> comprarProducto(1));

        btnSacarDelCarrito2.setOnAction(event -> sacarDelCarrito(2));
        btnComprar2.setOnAction(event -> comprarProducto(2));
    }

    // Métodos para manejar los eventos de los botones
    private void sacarDelCarrito(int productoId) {
        System.out.println("Producto " + productoId + " sacado del carrito.");
        // Aquí puedes añadir lógica para eliminar el producto del carrito en tu modelo de datos
    }

    private void comprarProducto(int productoId) {
        System.out.println("Producto " + productoId + " comprado.");
        // Aquí puedes añadir lógica para realizar la compra del producto
    }
}
