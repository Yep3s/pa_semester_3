package ControllerUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class LocalidadesDisponiblesEvento {

    @FXML
    private AnchorPane base;

    @FXML
    private TableColumn<?, ?> cantidad;

    @FXML
    private TableColumn<?, ?> nombre;

    @FXML
    private TableView<?> tablaLocalidad;

    @FXML
    private TableColumn<?, ?> valor;

    @FXML
    private Button volverAtras;

    @FXML
    void volverAtras(ActionEvent event) {

    }

}
