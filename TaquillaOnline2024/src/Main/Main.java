package Main;

import Sql.ConexionSql;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            try {

                ConexionSql conexion = ConexionSql.getInstance();
                conexion.setUser("root");
                conexion.setPassword("Cartagena2023-");
                conexion.setUrl("jdbc:mysql://localhost:3306/tutoriales_bd");
                conexion.setDriver("com.mysql.cj.jdbc.Driver");
                conexion.conectar();

                System.out.println("Conexion Exitosa");
            } catch (Exception e) {

                System.out.println("Error Al Conectar A La Base De Datos" + e.getMessage());

            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminView/0panelStart.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Taquilla Online");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
