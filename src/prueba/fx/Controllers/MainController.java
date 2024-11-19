package prueba.fx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController {

    @FXML
    private Button openLoginModal;

    @FXML
    private Button openRegisterModal;
    @FXML
    private Label userNameLabel;  // Etiqueta para mostrar el nombre del usuario
    @FXML
    private Button logoutButton;  // Botón para cerrar sesión

    private String userName;  // Variable para almacenar el nombre del usuario

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inicioTab;

    @FXML
    private Tab productosTab;

    @FXML
    private Tab carritoTab;

    @FXML
    private Tab historialTab;

    @FXML
    private Tab listaDeseosTab;

    @FXML
    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == inicioTab) {
                loadTabContent(inicioTab, "/prueba/fx/Components/inicio.fxml");
            } else if (newTab == productosTab) {
                loadTabContent(productosTab, "/prueba/fx/Components/productos.fxml");
            } else if (newTab == carritoTab) {
                loadTabContent(carritoTab, "/prueba/fx/Components/carrito.fxml");
            } else if (newTab == historialTab) {
                loadTabContent(historialTab, "/prueba/fx/Components/historial.fxml");
            } else if (newTab == listaDeseosTab) {
                loadTabContent(listaDeseosTab, "/prueba/fx/Components/listaDeseos.fxml");
            }
        });
    }

    private void loadTabContent(Tab tab, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();
            tab.setContent(content); // Coloca el contenido en el Tab
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para abrir el modal de Iniciar Sesión
    @FXML
    private void openLoginModal() {
        openModal("/prueba/fx/Components/login.fxml", "Iniciar Sesión");
    }

    // Método para abrir el modal de Registro
    @FXML
    private void openRegisterModal() {
        openModal("/prueba/fx/Components/register.fxml", "Registro");
    }

    // Método que se llama después de un inicio de sesión exitoso
public void onLoginSuccess(String name) {
    userName = name;  // Guardamos el nombre del usuario
    System.out.println("Login exitoso: " + userName);  // Depuración: Verificamos si el nombre se guarda correctamente
    updateUIAfterLogin();  // Actualizamos la interfaz
}

// Método que oculta los botones de iniciar sesión y registro y muestra el nombre del usuario y botón de logout
private void updateUIAfterLogin() {
    System.out.println("Actualizando UI después de login...");  // Depuración: Verificamos que este método se ejecute

    if (openLoginModal != null) {
        System.out.println("openLoginModal no es null, ocultando botón de Iniciar Sesión");  // Depuración
        openLoginModal.setVisible(false);  // Ocultar el botón de "Iniciar Sesión"
    } else {
        System.out.println("openLoginModal es null");  // Depuración: Verificamos si el objeto es null
    }

    if (openRegisterModal != null) {
        System.out.println("openRegisterModal no es null, ocultando botón de Registro");  // Depuración
        openRegisterModal.setVisible(false);  // Ocultar el botón de "Registro"
    } else {
        System.out.println("openRegisterModal es null");  // Depuración: Verificamos si el objeto es null
    }

    if (userNameLabel != null) {
        System.out.println("userNameLabel no es null, mostrando nombre de usuario");  // Depuración
        userNameLabel.setText("Bienvenido, " + userName);  // Mostrar el nombre del usuario
        userNameLabel.setVisible(true);  // Asegurar que la etiqueta sea visible
    } else {
        System.out.println("userNameLabel es null");  // Depuración: Verificamos si el objeto es null
    }

    if (logoutButton != null) {
        System.out.println("logoutButton no es null, haciendo visible el botón de cerrar sesión");  // Depuración
        logoutButton.setVisible(true);  // Hacer visible el botón de cerrar sesión
    } else {
        System.out.println("logoutButton es null");  // Depuración: Verificamos si el objeto es null
    }
}


    // Método para cerrar sesión
    @FXML
    private void handleLogout() {
        userName = null;  // Limpiamos el nombre del usuario
        openLoginModal.setVisible(true);  // Volver a mostrar el botón de "Iniciar Sesión"
        openRegisterModal.setVisible(true);  // Volver a mostrar el botón de "Registro"
        userNameLabel.setVisible(false);  // Ocultar el nombre del usuario
        logoutButton.setVisible(false);  // Ocultar el botón de "Cerrar sesión"
    }

    // Método para abrir el modal
    private void openModal(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle(title);
            modalStage.setScene(new Scene(loader.load()));

                    // Obtener el controlador de LoginController y pasar el MainController
        LoginController loginController = loader.getController();
        loginController.setMainController(this);
        
            modalStage.setMinWidth(400);  // Tamaño del modal
            modalStage.setMinHeight(300);  // Tamaño del modal
            modalStage.setResizable(false);

            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al cargar el modal: " + title).showAndWait();
        }
    }
}
