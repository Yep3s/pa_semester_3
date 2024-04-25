package Sql;

import Model.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioSql {

    ConexionSql conexion = ConexionSql.getInstance();

    public void guardar(UsuarioModel u) throws SQLException {

        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.getConnection().prepareStatement("insert into usuario_normal(nombre,cedula,telefono,correo,password) values(?,?,?,?,?)");
            sentencia.setString(1, u.getName());
            sentencia.setString(2, u.getCedula());
            sentencia.setString(3, u.getPhone());
            sentencia.setString(4, u.getEmail());
            sentencia.setString(5, u.getPassword());
            sentencia.execute();

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());

        }

    }

    public UsuarioModel login(String email, String password) throws SQLException {

        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        UsuarioModel u = null;

        try {

            sentencia = conexion.getConnection().prepareStatement("select * from usuario_normal where correo=? AND password=?");
            sentencia.setString(1, email);
            sentencia.setString(2, password);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                u = new UsuarioModel();
                u.setName(resultado.getString(2));
                u.setCedula(resultado.getString(3));
                u.setPhone(resultado.getString(4));
                u.setEmail(resultado.getString(5));
                u.setPassword(resultado.getString(6));

            }

        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());

        }
        
        return u;

    }

}
