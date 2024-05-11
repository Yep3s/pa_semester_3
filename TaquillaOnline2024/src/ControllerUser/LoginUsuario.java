package ControllerUser;

import Model.UsuarioModel;
import Sql.UsuarioSql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginUsuario {

    @FXML
    private AnchorPane base;

    @FXML
    private Label errorMessage;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordUser;

    @FXML
    private Text registro;

    @FXML
    private VBox usernameField;

    @FXML
    private TextField usuarioNormal;

    @FXML
    private Button volverAlStart;
    
      
        @FXML
    void passwordUserInput(KeyEvent event) {

    }
    
        @FXML
    void normalUserInput(KeyEvent event) {

    }

    @FXML
    void loginBtn(ActionEvent event) {

        try {
            UsuarioSql controller = new UsuarioSql();
            UsuarioModel usuario = controller.login(usuarioNormal.getText(), passwordUser.getText());

            if (usuario != null) {

                System.out.println("Existe Un Usuario");

            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/4menuUsuario.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Taquilla Online");
            stage.show();
            ((Stage) base.getScene().getWindow()).close();

        } catch (Exception e) {
        }

    }

    @FXML
    void registroClik(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserView/2crearUsuario.fxml"));
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
    void regresarAtrasBtn(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/0panelStart.fxml"));
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
