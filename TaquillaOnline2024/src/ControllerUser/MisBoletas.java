package ControllerUser;

import Model.BoletasCompradasModel;
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

public class MisBoletas implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private TableView<BoletasCompradasModel> boletasTableView;

    @FXML
    private TableColumn<BoletasCompradasModel, String> evento;

    @FXML
    private TableColumn<BoletasCompradasModel, String> localidad;

    @FXML
    private TableColumn<BoletasCompradasModel, String> uuid;

    @FXML
    private Button volverAtras;

    private ObservableList<BoletasCompradasModel> voletasCompradasTable = null;

    @FXML
    void volverAtras(ActionEvent event) {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LocalidadesSql localidadesControllerBd = new LocalidadesSql();
        try {
            ArrayList<BoletasCompradasModel> voletasCompradas = localidadesControllerBd.misBoletas();
            System.out.println(voletasCompradas);
            voletasCompradasTable = FXCollections.observableArrayList(voletasCompradas);
            uuid.setCellValueFactory(new PropertyValueFactory<BoletasCompradasModel, String>("uuid"));
            evento.setCellValueFactory(new PropertyValueFactory<BoletasCompradasModel, String>("event"));
            localidad.setCellValueFactory(new PropertyValueFactory<BoletasCompradasModel, String>("locality"));
            boletasTableView.setItems(voletasCompradasTable);
        } catch (Exception e) {
            System.out.println("error al obtener mis voletas" + e.getMessage());
        }

    }

}
