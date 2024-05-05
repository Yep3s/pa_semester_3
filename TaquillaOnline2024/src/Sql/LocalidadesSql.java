package Sql;

import Model.BoletasCompradasModel;
import Model.LocalidadModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;


public class LocalidadesSql {
    
    ConexionSql conexion = ConexionSql.getInstance();

    public void guardar(LocalidadModel l) throws SQLException {

        PreparedStatement sentencia = null;
        try {
            
            sentencia = conexion.getConnection().prepareStatement("insert into localidades(codigo,nombre,valor,capacidad) values(?,?,?,?)");
            sentencia.setString(1, l.getLocalityCode());
            sentencia.setString(2, l.getLocalityName());
            sentencia.setInt(3, l.getLocalityPrice());
            sentencia.setInt(4, l.getNumeroDeEspacios());
            sentencia.execute();

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

    }

    public LocalidadModel buscarLocalidades(String code) throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        LocalidadModel localidad = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("select * from localidades where codigo=?");
            sentencia.setString(1, code);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                System.out.println(resultado.getString(5));
                localidad = new LocalidadModel(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getInt(4),
                        resultado.getInt(5));
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }
        return localidad;
    }

    public ArrayList<LocalidadModel> obtenerTodasLasLocalidades() throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<LocalidadModel> eventos = new ArrayList<LocalidadModel>();
        try {
            sentencia = conexion.getConnection().prepareStatement("select * from localidades");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                eventos.add(
                        new LocalidadModel(
                                resultado.getInt(1),
                                resultado.getString(2),
                                resultado.getString(3),
                                resultado.getInt(4),
                                resultado.getInt(5)
                        )
                );
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

        return eventos;
    }

    public void guardarBoletas(int idLocalidad, int idEvento, int cantidadDeBoletas) throws SQLException {
        PreparedStatement sentencia = null;
        try {

            for (int i = 0; i < cantidadDeBoletas; i++) {
                sentencia = conexion.getConnection().prepareStatement("insert into voletas_compradas(id_localidad, id_evento, uuid) values(?,?,?)");
                sentencia.setInt(1, idLocalidad);
                sentencia.setInt(2, idEvento);
                sentencia.setString(3, UUID.randomUUID().toString().substring(0, 6)); ///utilizamos uuid para generar un codigo random
                sentencia.execute();
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }
    }

    public ArrayList<BoletasCompradasModel> misBoletas() throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<BoletasCompradasModel> boletasCompradas = new ArrayList<BoletasCompradasModel>();

        try {
            sentencia = conexion.getConnection().prepareStatement("select v.id, l.nombre as localidad, e.nombre as evento, v.uuid from voletas_compradas v join localidades l on v.id_localidad = l.id join eventos e on e.id = v.id_evento");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                boletasCompradas.add(
                        new BoletasCompradasModel(
                                resultado.getInt(1),
                                resultado.getString(2),
                                resultado.getString(3),
                                resultado.getString(4))
                );
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

        return boletasCompradas;
    }

    public BoletasCompradasModel buscarVoleta(String codigo) throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        BoletasCompradasModel boletasCompradas = null;

        try {
            sentencia = conexion.getConnection().prepareStatement("select v.id, l.nombre as localidad, e.nombre as evento, v.uuid from voletas_compradas v join localidades l on v.id_localidad = l.id join eventos e on e.id = v.id_evento where v.uuid = ?");
            sentencia.setString(1, codigo);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                boletasCompradas = new BoletasCompradasModel(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4));

            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

        return boletasCompradas;
    }
    
}
