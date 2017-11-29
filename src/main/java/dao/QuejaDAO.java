/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Queja;
import util.DbUtil;

/**
 *
 * @author Brenda
 */
public class QuejaDAO {

    private Connection connection;

    public QuejaDAO() throws URISyntaxException {
        connection = DbUtil.getConnection();
    }

    // estado 1=activo, 2=terminado falta revision, 3=revisado
    public void addQueja(Queja q) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into quejasTrabajadores(idUsuario,nombre,descripcion) values (?,?,?)");
        preparedStatement.setInt(1, q.getIdUsuario());
        preparedStatement.setString(2, q.getNombre());
        preparedStatement.setString(3, q.getDescripcion());       
        preparedStatement.executeUpdate();
    }

    public void deleteQueja(int idQueja) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from quejasTrabajadores where idQueja=?");
        preparedStatement.setInt(1, idQueja);
        preparedStatement.executeUpdate();
    }

    public void updateQueja(Queja q) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update quejasTrabajadores set idUsuario=?,nombre=?,descripcion=?" + " where idQueja=?");
        preparedStatement.setInt(1, q.getIdUsuario());
        preparedStatement.setString(2, q.getNombre());
        preparedStatement.setString(3, q.getDescripcion());   
        preparedStatement.setInt(4, q.getIdQueja());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Queja> getAllQuejas() throws SQLException {
        
        ArrayList<Queja> quejas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from quejasTrabajadores");
        while (rs.next()) {
            Queja q = new Queja();
            q.setIdQueja(rs.getInt("idQueja"));
             q.setIdUsuario(rs.getInt("idUsuario"));
             q.setNombre(rs.getString("nombre"));
             q.setDescripcion(rs.getString("descripcion"));
           
            quejas.add(q);
        }
        return quejas;
    }

    public Queja getQuejaById(int idQueja) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from quejasTrabajadores where idQueja=" + idQueja);
         Queja q = new Queja();
        if (rs.next()) {
            q.setIdQueja(rs.getInt("idQueja"));
             q.setIdUsuario(rs.getInt("idUsuario"));
             q.setNombre(rs.getString("nombre"));
             q.setDescripcion(rs.getString("descripcion"));
        }
        return q;
    }
}