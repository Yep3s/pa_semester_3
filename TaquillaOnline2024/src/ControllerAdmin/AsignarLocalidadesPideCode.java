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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/2menuAdmin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Taquilla Online");
            stage.show();
            ((Stage) base.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
