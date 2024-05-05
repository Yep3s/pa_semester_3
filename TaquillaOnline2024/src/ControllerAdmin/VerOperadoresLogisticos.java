package ControllerAdmin;

import Model.OpLogisticoModel;
import Sql.OpLogisticoSql;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VerOperadoresLogisticos implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private TableColumn<OpLogisticoModel, String> cedula;

    @FXML
    private TableColumn<OpLogisticoModel, String> correo;

    @FXML
    private TableColumn<OpLogisticoModel, String> nombre;

    @FXML
    private TableColumn<OpLogisticoModel, String> password;

    @FXML
    private TableView<OpLogisticoModel> tablaOpLogistico;

    @FXML
    private TableColumn<OpLogisticoModel, String> telefono;

    @FXML
    private Button volverAtrasMenu;

    private ObservableList<OpLogisticoModel> operador = null;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            OpLogisticoSql opLogisticoController = new OpLogisticoSql();
            ArrayList<OpLogisticoModel> operadoresDb = opLogisticoController.obtenerTodosLosOperadoresLogisticos();
            operador = FXCollections.observableArrayList(operadoresDb);
            nombre.setCellValueFactory(new PropertyValueFactory<OpLogisticoModel, String>("name"));
            cedula.setCellValueFactory(new PropertyValueFactory<OpLogisticoModel, String>("cedula"));
            telefono.setCellValueFactory(new PropertyValueFactory<OpLogisticoModel, String>("phone"));
            correo.setCellValueFactory(new PropertyValueFactory<OpLogisticoModel, String>("email"));
            password.setCellValueFactory(new PropertyValueFactory<OpLogisticoModel, String>("password"));

            tablaOpLogistico.setItems(operador);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

}
