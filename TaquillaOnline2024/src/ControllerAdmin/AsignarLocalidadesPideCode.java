package ControllerAdmin;

import Model.EventoLocalidadesModel;
import Model.EventoModel;
import Model.LocalidadModel;
import Sql.CrearEventoSql;
import Sql.EventoLocalidadesSql;
import Sql.LocalidadesSql;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AsignarLocalidadesPideCode {

    @FXML
    private Label CapacidadLocalidadLabel;

    @FXML
    private AnchorPane base;

    @FXML
    private Button botonVolver;

    @FXML
    private TextField codigoEvento;

    @FXML
    private TextField codigoLocalidad;

    @FXML
    private Label codigoLocalidadLabel;

    @FXML
    private Button consultarEventoBtn;

    @FXML
    private Button consultarLocalidadbtn;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label errorMessage;

    @FXML
    private Label eventNameLabel;

    @FXML
    private Label localidadLabel;

    @FXML
    private Button siguenteAsignacion;

    @FXML
    private Label valorLocalidadLabel;

    EventoModel eventoModel = null;
    LocalidadModel localidad = null;

    @FXML
    void consultarEvento(ActionEvent event) throws SQLException {
        try {
            CrearEventoSql controller = new CrearEventoSql();
            eventoModel = controller.buscarEventos(codigoEvento.getText());
            if (eventoModel != null) {
                eventNameLabel.setText("Nombre : " + eventoModel.getEventName());
                descriptionLabel.setText("Descripcion : " + eventoModel.getEventDescription());
                dateLabel.setText("Fecha : " + eventoModel.getEventDate());
            } else {
                System.out.println("no existe este evento");
                eventNameLabel.setText("");
                descriptionLabel.setText("");
                dateLabel.setText("");
            }

        } catch (Exception e) {
            System.out.println("error consultarEvento" + e.getMessage());
        }

    }
    
        public void limpiarLabelLocalidad() {
        localidadLabel.setText("");
        codigoLocalidadLabel.setText("");
        CapacidadLocalidadLabel.setText("");
        valorLocalidadLabel.setText("");
    }
    

    @FXML
    void consultarLocalidad(ActionEvent event) {
        
                try {
            System.out.println(codigoLocalidad.getText());
                    LocalidadesSql localidadesControllerBd = new LocalidadesSql();
            localidad = localidadesControllerBd.buscarLocalidades(codigoLocalidad.getText());
            System.out.println(localidad);
            if (localidad != null) {
                localidadLabel.setText("Nombre : " + localidad.getLocalityName());
                codigoLocalidadLabel.setText("Codigo : " + localidad.getLocalityCode());
                CapacidadLocalidadLabel.setText("Capacidad : " + localidad.getNumeroDeEspacios());
                valorLocalidadLabel.setText("Valor : " + localidad.getLocalityPrice());
            } else {
                limpiarLabelLocalidad();
            }
        } catch (Exception e) {
        }
        
    }

    @FXML
    void siguienteAsignacion(ActionEvent event) {
        
                if (eventoModel != null) {
            if (localidad != null) {
                try {
                    EventoLocalidadesSql eventoLocalidadesControlador = new EventoLocalidadesSql();
                    eventoLocalidadesControlador.guardar(new EventoLocalidadesModel(eventoModel.getId(), localidad.getId()));
                    localidad = null;
                    limpiarLabelLocalidad();
                    System.out.println("guardado");
                } catch (Exception e) {
                }
            } else {
                System.out.println("Ingrese una localidad");
            }
        } else {
            System.out.println("Ingrese el evento");
        }
        

    }

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

}
