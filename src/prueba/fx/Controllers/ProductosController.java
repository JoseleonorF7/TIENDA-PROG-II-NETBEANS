package prueba.fx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

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

        // Evento del botón de búsqueda
        searchButton.setOnAction(e -> buscarProductos());

        // Evento del filtro por precio
        filterByPriceButton.setOnAction(e -> filtrarPorPrecio());

        // Evento del filtro por popularidad
        filterByPopularityButton.setOnAction(e -> filtrarPorPopularidad());

        // Cargar productos iniciales en el panel
        cargarProductos();
    }

private void buscarProductos() {
    String query = searchField.getText().toLowerCase();
    productPane.getChildren().clear(); // Limpiar el panel de productos

    // Simulación de búsqueda
    for (int i = 1; i <= 6; i++) {
        String productName = "Producto " + i;
        if (productName.toLowerCase().contains(query)) {
            Pane product = crearProducto(productName, "file:src/main/resources/prueba/fx/images/product" + i + ".png");
            productPane.getChildren().add(product);
        }
    }

    if (productPane.getChildren().isEmpty()) {
        System.out.println("No se encontraron productos para: " + query);
    }
}

private void filtrarPorPrecio() {
    productPane.getChildren().clear(); // Limpiar el panel de productos

    // Simulación: Productos ordenados por precio (en este ejemplo, el ID representa el precio)
    for (int i = 1; i <= 6; i++) {
        Pane product = crearProducto("Producto " + i + " - Precio: $" + (i * 10),
                "file:src/main/resources/prueba/fx/images/product" + i + ".png");
        productPane.getChildren().add(product);
    }

    System.out.println("Productos filtrados por precio.");
}

private void filtrarPorPopularidad() {
    productPane.getChildren().clear(); // Limpiar el panel de productos

    // Simulación: Productos ordenados por popularidad (inverso del ID para variar)
    for (int i = 6; i >= 1; i--) {
        Pane product = crearProducto("Producto " + i + " - Popularidad: " + i + " estrellas",
                "file:src/main/resources/prueba/fx/images/product" + i + ".png");
        productPane.getChildren().add(product);
    }

    System.out.println("Productos filtrados por popularidad.");
}

    private void cargarProductos() {
        productPane.getChildren().clear(); // Limpiar productos anteriores
        for (int i = 1; i <= 6; i++) {
            Pane product = crearProducto("Producto " + i, "file:src/main/resources/prueba/fx/images/product" + i + ".png");
            productPane.getChildren().add(product);
        }
    }

    private Pane crearProducto(String nombre, String imagePath) {
        Pane productPane = new Pane();
        productPane.setPrefSize(150, 200);
        productPane.setStyle("-fx-background-color: #b2aaaa; -fx-border-color: black;");

        // Imagen del producto
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(140);
        imageView.setFitHeight(120);
        imageView.setLayoutX(5);
        imageView.setLayoutY(5);

        // Botón de detalles
        Button detailsButton = new Button("Detalles");
        detailsButton.setStyle("-fx-background-color: #6f75eb;");
        detailsButton.setLayoutX(10);
        detailsButton.setLayoutY(140);
        detailsButton.setOnAction(e -> System.out.println("Ver detalles de " + nombre));

        // Botón de agregar al carrito
        Button addToCartButton = new Button("Agregar carrito");
        addToCartButton.setStyle("-fx-background-color: #18cd24;");
        addToCartButton.setLayoutX(80);
        addToCartButton.setLayoutY(140);
        addToCartButton.setOnAction(e -> System.out.println(nombre + " agregado al carrito"));

        productPane.getChildren().addAll(imageView, detailsButton, addToCartButton);
        return productPane;
    }
}
