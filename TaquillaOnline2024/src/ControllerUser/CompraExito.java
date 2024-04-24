package ControllerUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CompraExito {

    @FXML
    private Button aceptarUsuario;

    @FXML
    private AnchorPane base;

    @FXML
    void volverAlMenuPrincipalUsuario(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/4menuUsuario.fxml"));
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
