package ControllerUser;

import Model.EventoModel;
import Sql.CrearEventoSql;
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

public class EventosDisponiblesUser implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private TableColumn<EventoModel, String> codigo;

    @FXML
    private TableColumn<EventoModel, String> descripcion;

    @FXML
    private TableColumn<EventoModel, String> fecha;

    @FXML
    private TableColumn<EventoModel, String> nombre;

    @FXML
    private TableView<EventoModel> tablaEventos;

    @FXML
    private Button volverAtras;

    CrearEventoSql controller = new CrearEventoSql();
    ObservableList<EventoModel> eventosList = null;

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
        
                try {
            ArrayList<EventoModel> eventos = controller.obtenerTodosLosEventos();
            System.out.println("eventos" + eventos);
            eventosList = FXCollections.observableArrayList(eventos);
            nombre.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("eventName"));
            descripcion.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("eventDescription"));
            fecha.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("eventDate"));
            codigo.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("code"));

            tablaEventos.setItems(eventosList);
 
            tablaEventos.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                        EventoModel eventoModel = tablaEventos.getSelectionModel().getSelectedItem();
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/localidadesDisponiblesEvento.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.setTitle("Taquilla Online"); 
                            LocalidadesDisponiblesEvento localidadesDisponiblesEvento =  (LocalidadesDisponiblesEvento) loader.getController();
                            localidadesDisponiblesEvento.setEventoModel(eventoModel);
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
