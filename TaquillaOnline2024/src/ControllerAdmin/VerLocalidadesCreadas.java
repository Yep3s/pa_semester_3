package ControllerAdmin;

import Model.LocalidadModel;
import Sql.LocalidadesSql;
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

public class VerLocalidadesCreadas implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private Button botonVolver;

    @FXML
    private TableColumn<LocalidadModel, Integer> capacidad;

    @FXML
    private TableColumn<LocalidadModel, String> codigo;

    @FXML
    private TableColumn<LocalidadModel, Integer> id;

    @FXML
    private TableView<LocalidadModel> localidadesTable;

    @FXML
    private TableColumn<LocalidadModel, String> nombre;

    @FXML
    private TableColumn<LocalidadModel, Integer> valor;

    private ObservableList<LocalidadModel> localidades = null;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
                try {
                    LocalidadesSql localidadesControllerBd = new LocalidadesSql();
            ArrayList<LocalidadModel> localidadesDb = localidadesControllerBd.obtenerTodasLasLocalidades();
            localidades = FXCollections.observableArrayList(localidadesDb);
            id.setCellValueFactory(new PropertyValueFactory<LocalidadModel, Integer>("id"));
            codigo.setCellValueFactory(new PropertyValueFactory<LocalidadModel, String>("localityCode"));
            nombre.setCellValueFactory(new PropertyValueFactory<LocalidadModel, String>("localityName"));
            valor.setCellValueFactory(new PropertyValueFactory<LocalidadModel, Integer>("localityPrice"));
            capacidad.setCellValueFactory(new PropertyValueFactory<LocalidadModel, Integer>("numeroDeEspacios"));
            localidadesTable.setItems(localidades);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

}
