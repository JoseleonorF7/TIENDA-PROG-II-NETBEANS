/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.fx;

/**
 *
 * @author Usuario
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        try {
            // Actualiza la ruta al archivo Main.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/prueba/fx/components/Main.fxml"));
            Scene scene = new Scene(root, 750, 500);
            primaryStage.setTitle("Tienda Virtual");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
