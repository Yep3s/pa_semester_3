package ControllerOperator;

import Model.OpLogisticoModel;
import Sql.OpLogisticoSql;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginOpLogistico {

    @FXML
    private AnchorPane base;

    @FXML
    private Label errorMessage;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordOpLogistico;

    @FXML
    private VBox usernameField;

    @FXML
    private TextField usuarioOpLogistico;

    @FXML
    private Button volverAlStart;

    @FXML
    void passwordOpLogisticoInput(KeyEvent event) {

    }

    @FXML
    void loginBtn(ActionEvent event) {

        try {

            OpLogisticoSql controller = new OpLogisticoSql();

            OpLogisticoModel usuario = controller.login(usuarioOpLogistico.getText(), passwordOpLogistico.getText());

            if (usuario != null) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogisticOperatorView/2menuOpLogistico.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Taquilla Online");
                stage.show();
                ((Stage) base.getScene().getWindow()).close();

            }

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

    @FXML
    void usuarioOpLogisticoInput(KeyEvent event) {

    }

}
