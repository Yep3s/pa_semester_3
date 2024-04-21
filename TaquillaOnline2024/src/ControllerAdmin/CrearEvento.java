package ControllerAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearEvento {

    @FXML
    private Button atrasBtn;

    @FXML
    private AnchorPane base;

    @FXML
    private TextField eventCode;

    @FXML
    private DatePicker eventDate;

    @FXML
    private TextArea eventDescription;

    @FXML
    private TextField eventName;

    @FXML
    private Button siguienteBtn;

    @FXML
    void atrasBtn(ActionEvent event) {
        
                                         try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/2menuAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la segunda vista
            // Si es necesario realizar acciones en el controlador de la segunda vista, obtén el controlador aquís
            // Ejemplo: SegundoControlador controller = loader.getController();
            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Taquilla Online"); // Puedes personalizar el título

            // Mostrar la nueva ventana
            stage.show();

            // Cerrar la ventana actual (opcional)
            ((Stage) base.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

    }

    @FXML
    void siguienteBtn(ActionEvent event) {

    }

}
