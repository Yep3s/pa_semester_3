package ControllerAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuAdmin {

    @FXML
    private Button asignarLocalidades;

    @FXML
    private AnchorPane base;

    @FXML
    private Button cerrarSesion;

    @FXML
    private Button crearEvento;

    @FXML
    private Button crearLocalidades;

    @FXML
    private Button crearOpLogistico;

    @FXML
    private Button datosEstadisticos;

    @FXML
    private Button verEventos;

    @FXML
    private Button verLocalidades;

    @FXML
    private Button verOpLogistico;

    @FXML
    void AsignarLocalidades(ActionEvent event) {

    }

    @FXML
    void cerrarSesionBtn(ActionEvent event) {
        
                                 try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/1Login.fxml"));
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
    void crearEventoBtn(ActionEvent event) {

    }

    @FXML
    void crearLocalidades(ActionEvent event) {

    }

    @FXML
    void crearOpBtn(ActionEvent event) {

    }

    @FXML
    void datosEstadisticos(ActionEvent event) {

    }

    @FXML
    void verEventosBtn(ActionEvent event) {

    }

    @FXML
    void verLocalidades(ActionEvent event) {

    }

    @FXML
    void verOpBtn(ActionEvent event) {

    }

}
