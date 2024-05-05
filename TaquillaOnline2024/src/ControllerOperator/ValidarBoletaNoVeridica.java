package ControllerOperator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ValidarBoletaNoVeridica {

    @FXML
    private AnchorPane base;

    @FXML
    private Button volverAtras;

    @FXML
    void volverAtras(ActionEvent event) throws IOException {
        
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/3validarBoleteriaOpLogistico.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Taquilla Online");
            stage.show();
            ((Stage) base.getScene().getWindow()).close();

    }

}
