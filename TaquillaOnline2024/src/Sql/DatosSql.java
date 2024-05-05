package Sql;

import Model.EventoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatosSql {

    ConexionSql conexion = ConexionSql.getInstance();

    public ArrayList<EventoModel> obtenerTodosLosEventos() throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<EventoModel> eventos = new ArrayList<EventoModel>();

        try {
            
            sentencia = conexion.getConnection().prepareStatement("select * from eventos");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                eventos.add(
                        new EventoModel(
                                resultado.getInt(1),
                                resultado.getString(5),
                                resultado.getString(2),
                                resultado.getString(3),
                                resultado.getString(4)
                        )
                );
            }

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());

        }
        return eventos;
    }

}
