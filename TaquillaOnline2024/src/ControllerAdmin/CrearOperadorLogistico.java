package ControllerAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearOperadorLogistico {

    @FXML
    private TextField OpTelefono;

    @FXML
    private Button atrasBtn;

    @FXML
    private AnchorPane base;

    @FXML
    private Button guardar;

    @FXML
    private TextField opCedula;

    @FXML
    private TextField opEmail;

    @FXML
    private TextField opName;

    @FXML
    private TextField opPassword;

    @FXML
    void atrasBtn(ActionEvent event) {

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

    @FXML
    void guardarBtn(ActionEvent event) {
        
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/8crearOperadorLogisticoGuardado.fxml"));
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
