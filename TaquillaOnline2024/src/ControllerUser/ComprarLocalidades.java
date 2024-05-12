package ControllerUser;

import Model.EventoModel;
import Model.LocalidadModel;
import Sql.LocalidadesSql;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ComprarLocalidades implements Initializable {
    

    @FXML
    private AnchorPane base;

    @FXML
    private Button calcularTotal;

    @FXML
    private TextField cantidadBoletas;

    @FXML
    private Button comprar;

    @FXML
    private Label nombreLocalidadSelet;

    @FXML
    private Label precioFinal;

    @FXML
    private Label valorLocalidadSelet;

    @FXML
    private Button volverAtras;

    private EventoModel eventoModel = null;
    private LocalidadModel localidad = null;

    public void setEvento(EventoModel e) {
        eventoModel = e;
    }

    public void setLocalidad(LocalidadModel l) {
        localidad = l;
        nombreLocalidadSelet.setText(localidad.getLocalityName());
        valorLocalidadSelet.setText(localidad.getLocalityPrice() + "");

    }

    @FXML
    void calcularValorTotal(ActionEvent event) {
        int numeroVoletas = Integer.parseInt(cantidadBoletas.getText());
        precioFinal.setText(numeroVoletas * localidad.getLocalityPrice() + "");
    }

    @FXML
    void comprarLocalidades(ActionEvent event) {

        LocalidadesSql localidadesControllerBd = new LocalidadesSql();
        try {
            localidadesControllerBd.guardarBoletas(
                    localidad.getId(),
                    eventoModel.getId(),
                    Integer.parseInt(cantidadBoletas.getText())
            );
            cantidadBoletas.setText("");
            precioFinal.setText("");
            System.out.println("voletas compradas");
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/compraRealizadaExito.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Taquilla Online");
            stage.show();
            ((Stage) base.getScene().getWindow()).close();

            
            
            
            
            
        } catch (Exception e) {
            System.out.println("error al guardar las voletas" + e.getMessage());
        }

    }

    @FXML
    void volverAtras(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/localidadesDisponiblesEvento.fxml"));
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

    }

}
