package ControllerOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuOpLogistico {

    @FXML
    private AnchorPane base;

    @FXML
    private Button cerrarSesion;

    @FXML
    private Button validarBoleta;

    @FXML
    void cerrarSesionBtn(ActionEvent event) {
        
        
        
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/1LoginOpLogistico.fxml"));
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
    void validarBoletaBtn(ActionEvent event) {
        
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/3validarBoleteriaOpLogistico.fxml"));
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
