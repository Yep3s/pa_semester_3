package ControllerOperator;

import Model.BoletasCompradasModel;
import Sql.LocalidadesSql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ValidarBoletaOpLogistico {

    @FXML
    private AnchorPane base;

    @FXML
    private TextField validarBoleta;

    @FXML
    private Button verificarBoton;

    @FXML
    private Button volverAnteriorVentana;

    @FXML
    void verificarBtn(ActionEvent event) {

        try {
            String codigo = validarBoleta.getText();
            LocalidadesSql localidadesControllerBd = new LocalidadesSql();
            BoletasCompradasModel voletasComprada = localidadesControllerBd.buscarVoleta(codigo);
            if (voletasComprada != null) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/4validacionBoletaVeridica.fxml"));
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

            } else {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/5validacionBoletaNoVeridica.fxml"));
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
                System.out.println("no existe");
            }
        } catch (Exception e) {
        }

    }

    @FXML
    void volverAnteriorBtn(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/2menuOpLogistico.fxml"));
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
