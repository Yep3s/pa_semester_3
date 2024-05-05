package ControllerAdmin;

import Model.EventoModel;
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

public class VerEventosCreados implements Initializable{

    @FXML
    private AnchorPane base;

    @FXML
    private Button botonVolver;

    @FXML
    private TableColumn<EventoModel, String> codigo;

    @FXML
    private TableColumn<EventoModel, String> descripcion;

    @FXML
    private TableColumn<EventoModel, String> fecha;

    @FXML
    private TableColumn<EventoModel, Integer> id;

    @FXML
    private TableColumn<EventoModel, String> nombre;

    @FXML
    private TableView<EventoModel> tableEventos;
    
    CrearEventoSql controller = new CrearEventoSql();
        ObservableList<EventoModel> eventosList = null;
    

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
            ArrayList<EventoModel> eventos = controller.obtenerTodosLosEventos();
            System.out.println("eventos" + eventos);
            eventosList = FXCollections.observableArrayList(eventos);
            id.setCellValueFactory(new PropertyValueFactory<EventoModel, Integer>("id"));
            nombre.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("EventName"));
            descripcion.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("eventDescription"));
            fecha.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("eventDate"));
            codigo.setCellValueFactory(new PropertyValueFactory<EventoModel, String>("code"));

            tableEventos.setItems(eventosList);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }
    

}
