package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
     @Override
    public void start(Stage primaryStage) {
        try {

            // Cargar el archivo FXML de la primera vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/0panelStart.fxml"));
            Parent root = loader.load();

            // Configurar el controlador si es necesario
            // Ejemplo: PanelStart controller = loader.getController();
            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);

            // Configurar la escena en la etapa principal
            primaryStage.setScene(scene);
            primaryStage.setTitle("Taquilla Online"); // Puedes personalizar el título
            primaryStage.show(); //show es mostrar

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
    
    
}
