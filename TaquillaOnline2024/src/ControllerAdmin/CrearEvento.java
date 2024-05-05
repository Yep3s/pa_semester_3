package ControllerAdmin;

import Model.EventoModel;
import Sql.CrearEventoSql;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearEvento {

    @FXML
    private Button atrasBtn;

    @FXML
    private AnchorPane base;

    @FXML
    private TextField eventCode;

    @FXML
    private DatePicker eventDate;

    @FXML
    private TextArea eventDescription;

    @FXML
    private TextField eventName;

    @FXML
    private Button siguienteBtn;

    public void obtenerFechaComoString() {
        if (eventDate.getValue() != null) {
            String fechaFormateada = formatDate(eventDate.getValue());
            System.out.println("Fecha seleccionada: " + fechaFormateada);
        } else {
            System.out.println("No se ha seleccionado ninguna fecha.");
        }
    }

    private String formatDate(java.time.LocalDate date) {
        DateTimeFormatter fechaString = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return date.format(fechaString);
    }

    @FXML
    void atrasBtn(ActionEvent event) {

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

    @FXML
    void siguienteBtn(ActionEvent event) {

        String codigo = eventCode.getText();
        String nombre = eventName.getText();
        String descripcion = eventDescription.getText();
        String fecha = null;

        if (eventDate.getValue() != null) {
            fecha = formatDate(eventDate.getValue());
        }

        try {
            CrearEventoSql controller = new CrearEventoSql();
            EventoModel eventoModelBuscar = controller.buscarEventos(eventCode.getText());
            if (eventoModelBuscar != null) {

                System.out.println("Ya Existe Un Evento Con Este Codigo");

            } else {

                controller.guardar(new EventoModel(codigo, nombre, descripcion, fecha));
                System.out.println("Registro Exitoso");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/5guardadoCrearEvento.fxml"));
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

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
