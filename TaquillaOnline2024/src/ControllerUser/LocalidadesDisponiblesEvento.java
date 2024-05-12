package ControllerUser;

import Model.EventoModel;
import Model.LocalidadModel;
import Sql.LocalidadesSql;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LocalidadesDisponiblesEvento implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private TableColumn<LocalidadModel, Integer> cantidad;

    @FXML
    private TableColumn<LocalidadModel, String> nombre;

    @FXML
    private TableView<LocalidadModel> tablaLocalidad;

    @FXML
    private TableColumn<LocalidadModel, Integer> valor;

    @FXML
    private Button volverAtras;

    ObservableList<LocalidadModel> localidades = null;

    private EventoModel eventoModel = null;

    public void setEventoModel(EventoModel e) {
        eventoModel = e;
    }

    @FXML
    void volverAtras(ActionEvent event) {
        
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/5verYComprarEventos.fxml"));
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
        
                System.out.println(eventoModel);
        try {
            LocalidadesSql localidadesControllerBd = new LocalidadesSql();
            ArrayList<LocalidadModel> localidadesDb = localidadesControllerBd.obtenerTodasLasLocalidades();
            localidades = FXCollections.observableArrayList(localidadesDb);
            nombre.setCellValueFactory(new PropertyValueFactory<LocalidadModel, String>("localityName"));
            valor.setCellValueFactory(new PropertyValueFactory<LocalidadModel, Integer>("localityPrice"));
            cantidad.setCellValueFactory(new PropertyValueFactory<LocalidadModel, Integer>("numeroDeEspacios"));
            tablaLocalidad.setItems(localidades);

            tablaLocalidad.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                        LocalidadModel localidad = tablaLocalidad.getSelectionModel().getSelectedItem();

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/comprarLocalidades.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.setTitle("Taquilla Online");
                            ComprarLocalidades comprarLocalidades = (ComprarLocalidades) loader.getController();
                            comprarLocalidades.setEvento(eventoModel);
                            comprarLocalidades.setLocalidad(localidad);
                            stage.show();

                            ((Stage) base.getScene().getWindow()).close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }



    }

}
