package Sql;

import Model.EventoLocalidadesModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoLocalidadesSql {

    ConexionSql conexion = ConexionSql.getInstance();

    public void guardar(EventoLocalidadesModel e) throws SQLException {

        PreparedStatement setencia = null;

        try {
            
            setencia = conexion.getConnection().prepareStatement("insert into eventos_localidad(id_evento, id_localidades) values(?,?)");
            setencia.setInt(1, e.getEventId());
            setencia.setInt(2, e.getLocalityId());
            setencia.execute();

        } catch (SQLException err) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + err.getMessage());
        }
    }

}
