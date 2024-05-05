package ControllerAdmin;

import Model.LocalidadModel;
import Sql.LocalidadesSql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearEventoLocalidades {

    @FXML
    private Button atras;

    @FXML
    private AnchorPane base;

    @FXML
    private Button guardar;

    @FXML
    private TextField localityCode;

    @FXML
    private TextField localityName;

    @FXML
    private TextField localityPrice;

    @FXML
    private TextField localitySpaces;

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
    void guardarBtn(ActionEvent event) {

        try {

            LocalidadesSql controller = new LocalidadesSql();

            if (controller.buscarLocalidades(localityCode.getText()) != null) {
                System.out.println("Ya Existe una localidad con este codigo");
            } else {

                String codigoLocalidad = localityCode.getText();
                String nombreLocalidad = localityName.getText();
                int valorLocalidad = Integer.valueOf(localityPrice.getText());
                int espaciosLocalidad = Integer.valueOf(localitySpaces.getText());

                controller.guardar(new LocalidadModel(codigoLocalidad, nombreLocalidad, valorLocalidad, espaciosLocalidad));

                System.out.println("registro exitoso");
                localityName.setText("");
                localitySpaces.setText("");
                localityPrice.setText("");
                localityCode.setText("");
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/5.1guardadoLocalidad.fxml"));
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
