package ControllerAdmin;

import Model.EventosVendidosModel;
import Sql.CrearEventoSql;
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

public class DatosEstadisticos implements Initializable {

    @FXML
    private AnchorPane base;

    @FXML
    private Button botonVolver;

    @FXML
    private TableColumn<EventosVendidosModel, Integer> cantidad;

    @FXML
    private TableColumn<EventosVendidosModel, String> evento;

    @FXML
    private TableColumn<EventosVendidosModel, String> localidad;

    @FXML
    private TableView<EventosVendidosModel> tableEventos;

    @FXML
    private TableColumn<EventosVendidosModel, Integer> total;

    CrearEventoSql controller = new CrearEventoSql();

    ObservableList<EventosVendidosModel> eventosVendidosTable = null;

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
            /* ArrayList<EventoModel> eventos = crearEventoControlador.obtenerTodoLosEventos();
            System.out.println("eventos" + eventos);
            eventosList = FXCollections.observableArrayList(eventos);
            nombre.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("nombreDelEvento"));
            descripcion.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("descripcionDelEvento"));
            fecha.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("fechaDelEvento"));
            codigo.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("codigo"));

            tableEventos.setItems(eventosList);*/
            CrearEventoSql crearEventoControlador = new CrearEventoSql();
            ArrayList<EventosVendidosModel> eventosVendidos = crearEventoControlador.eventosVendidos();
            eventosVendidosTable = FXCollections.observableArrayList(eventosVendidos);
            evento.setCellValueFactory(new PropertyValueFactory<EventosVendidosModel, String>("event"));
            localidad.setCellValueFactory(new PropertyValueFactory<EventosVendidosModel, String>("locality"));
            cantidad.setCellValueFactory(new PropertyValueFactory<EventosVendidosModel, Integer>("quantity"));
            total.setCellValueFactory(new PropertyValueFactory<EventosVendidosModel, Integer>("total"));
            
            tableEventos.setItems(eventosVendidosTable);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        

    }

}
