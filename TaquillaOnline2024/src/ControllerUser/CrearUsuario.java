package ControllerUser;

import Model.UsuarioModel;
import Sql.UsuarioSql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearUsuario {

    @FXML
    private AnchorPane base;

    @FXML
    private TextField cedulaNuevo;

    @FXML
    private TextField correoNuevo;

    @FXML
    private Button crearUsuarioNuevo;

    @FXML
    private TextField nombreNuevo;

    @FXML
    private PasswordField passwordNuevo;

    @FXML
    private TextField telefonoNuevo;

    @FXML
    private Button volverAtrasNuevo;
    
        @FXML
    void telefonoNuevoInput(KeyEvent event) {

    }
    
        @FXML
    void passwordNuevoInput(KeyEvent event) {

    }
    
        @FXML
    void nuevoNombreInput(KeyEvent event) {

    }
    
        @FXML
    void cedulaNuevoInput(KeyEvent event) {

    }

    @FXML
    void correoNuevoInput(KeyEvent event) {

    }
    

    @FXML
    void crearUsuarioNuevoBtn(ActionEvent event) {

        UsuarioModel usuario = new UsuarioModel();

        usuario.setName(nombreNuevo.getText());
        usuario.setCedula(cedulaNuevo.getText());
        usuario.setPhone(telefonoNuevo.getText());
        usuario.setEmail(correoNuevo.getText());
        usuario.setPassword(passwordNuevo.getText());

        UsuarioSql controller = new UsuarioSql();

        try {

            controller.guardar(usuario);
            System.out.println("Registro Exitoso");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/3usuarioCreadoExito.fxml"));
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
    void volverAtrasBtn(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/1LoginUsuario.fxml"));
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
