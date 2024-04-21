package ControllerOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ValidarBoletaOpLogistico {

    @FXML
    private AnchorPane base;

    @FXML
    private TextField validarBoleta;

    @FXML
    private Button verificarBoton;

    @FXML
    private Button volverAnteriorVentana;

    @FXML
    void validarBoletaInput(KeyEvent event) {

    }

    @FXML
    void verificarBtn(ActionEvent event) {
        
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/4validacionBoletaVeridica.fxml"));
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
    void volverAnteriorBtn(ActionEvent event) {
        
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/2menuOpLogistico.fxml"));
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
