package prueba.fx.Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoginController implements Initializable {

    @FXML
    private TextField idField, nameField, phoneField, emailField;

    @FXML
    private PasswordField passwordField;

    // Ruta para guardar el archivo en el Escritorio del usuario
    private static final String FILE_PATH = Paths.get(System.getProperty("user.home"), "Desktop", "cuentas.txt").toString();

    private MainController mainController; // Inyecta MainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Correo y Contraseña son requeridos", Alert.AlertType.ERROR);
            return;
        }

        if (validateLogin(email, password)) {
            showAlert("Iniciar Sesión", "Inicio de sesión exitoso!", Alert.AlertType.INFORMATION);
            mainController.onLoginSuccess(email);  // Llama al método en MainController
            closeWindow();
        } else {
            showAlert("Error", "Correo o Contraseña incorrectos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleRegister() {
        String id = idField.getText();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Validaciones
        if (id.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Todos los campos son requeridos", Alert.AlertType.ERROR);
            return;
        }

        if (!isValidEmail(email)) {
            showAlert("Error", "El correo no tiene un formato válido", Alert.AlertType.ERROR);
            return;
        }

        if (password.length() < 6) {
            showAlert("Error", "La contraseña debe tener al menos 6 caracteres", Alert.AlertType.ERROR);
            return;
        }

        // Registro en el archivo
        if (registerAccount(email, password)) {
            showAlert("Registro", "Registro exitoso!", Alert.AlertType.INFORMATION);
            closeWindow(); // Cierra el modal
        } else {
            showAlert("Error", "Ocurrió un error al registrar la cuenta", Alert.AlertType.ERROR);
        }
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean registerAccount(String email, String password) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // Crea la carpeta si no existe

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(email + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validateLogin(String email, String password) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("El archivo de cuentas no existe.");
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] account = line.split(",");
                if (account.length == 2 && account[0].equals(email) && account[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Método para cerrar el modal
    private void closeWindow() {
        Stage stage = (Stage) emailField.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Código de inicialización si es necesario
    }
}
