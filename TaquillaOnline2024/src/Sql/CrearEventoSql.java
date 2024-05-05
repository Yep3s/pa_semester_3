package Sql;

import Model.EventoModel;
import Model.EventosVendidosModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrearEventoSql {

    ConexionSql conexion = ConexionSql.getInstance();

    public void guardar(EventoModel u) throws SQLException {

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("insert into eventos (codigo, nombre, descripcion, fecha) values(?,?,?,?)");
            sentencia.setString(1, u.getCode());
            sentencia.setString(2, u.getEventName());
            sentencia.setString(3, u.getEventDescription());
            sentencia.setString(4, u.getEventDate());
            sentencia.execute();

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

    }

    public EventoModel buscarEventos(String code) throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        EventoModel eventoModel = null;
        try {

            sentencia = conexion.getConnection().prepareStatement("select * from eventos where codigo=?");
            sentencia.setString(1, code);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                System.out.println(resultado.getString(5));
                eventoModel = new EventoModel(
                        resultado.getInt(1),
                        resultado.getString(5),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4)
                );

            }

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }
        return eventoModel;
    }

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

    public ArrayList<EventosVendidosModel> eventosVendidos() throws SQLException {

        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<EventosVendidosModel> eventosVendidos = new ArrayList<EventosVendidosModel>();

        try {
            sentencia = conexion.getConnection().prepareStatement("select  e.nombre as evento, l.nombre as localidad, count(*) as cantidad, sum(l.valor) as total, l.codigo from voletas_compradas vc\n"
                    + " inner join eventos e on e.id = vc.id_evento inner join localidades l on l.id = vc.id_localidad GROUP BY l.codigo, l.nombre, e.nombre order by e.nombre;");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                eventosVendidos.add(
                        new EventosVendidosModel(
                                resultado.getString(1),
                                resultado.getString(2),
                                resultado.getInt(3),
                                resultado.getInt(4)
                        )
                );
            }

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());

        }

        return eventosVendidos;

    }

}
