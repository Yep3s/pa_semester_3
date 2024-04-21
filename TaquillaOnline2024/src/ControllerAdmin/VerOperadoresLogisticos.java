package ControllerAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VerOperadoresLogisticos {

    @FXML
    private AnchorPane base;

    @FXML
    private TableColumn<?, ?> cedula;

    @FXML
    private TableColumn<?, ?> correo;

    @FXML
    private TableColumn<?, ?> nombre;

    @FXML
    private TableColumn<?, ?> password;

    @FXML
    private TableView<?> tablaOpLogistico;

    @FXML
    private TableColumn<?, ?> telefono;

    @FXML
    private Button volverAtrasMenu;

    @FXML
    void volverAlMenuPrincipal(ActionEvent event) {
        
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
