package ControllerAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AsignarLocalidadesPideCode {

    @FXML
    private Label CapacidadLocalidadLabel;

    @FXML
    private AnchorPane base;

    @FXML
    private Button botonVolver;

    @FXML
    private TextField codigoEvento;

    @FXML
    private TextField codigoLocalidad;

    @FXML
    private Label codigoLocalidadLabel;

    @FXML
    private Button consultarEventoBtn;

    @FXML
    private Button consultarLocalidadbtn;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label errorMessage;

    @FXML
    private Label eventNameLabel;

    @FXML
    private Label localidadLabel;

    @FXML
    private Button siguenteAsignacion;

    @FXML
    private Label valorLocalidadLabel;

    @FXML
    void consultarEvento(ActionEvent event) {

    }

    @FXML
    void consultarLocalidad(ActionEvent event) {

    }

    @FXML
    void siguienteAsignacion(ActionEvent event) {

    }

    @FXML
    void volverBtn(ActionEvent event) {
        
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

}
