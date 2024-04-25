/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql;

import Model.OpLogisticoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public class OpLogisticoSql {

    ConexionSql conexion = ConexionSql.getInstance();

    public void guardar(OpLogisticoModel u) throws SQLException {

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("insert into operadores_logisticos(nombre,cedula,telefono,correo,password) values(?,?,?,?,?)");
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

    public OpLogisticoModel login(String email, String password) throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        OpLogisticoModel u = null;

        try {
            sentencia = conexion.getConnection().prepareStatement("select * from operadores_logisticos where correo=? AND password=?");
            sentencia.setString(1, email);
            sentencia.setString(2, password);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                u = new OpLogisticoModel();
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
    
    
        public ArrayList<OpLogisticoModel> obtenerTodosLosOperadoresLogisticos() throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<OpLogisticoModel> operador = new ArrayList<OpLogisticoModel>();

        try {
            sentencia = conexion.getConnection().prepareStatement("select * from operadores_logisticos");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                operador.add(
                        new OpLogisticoModel(
                                resultado.getInt(1),
                                resultado.getString(2),
                                resultado.getString(3),
                                resultado.getString(4),
                                resultado.getString(5),
                                resultado.getString(6)
                        )
                );
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

        return operador;
    }
    
    

}
