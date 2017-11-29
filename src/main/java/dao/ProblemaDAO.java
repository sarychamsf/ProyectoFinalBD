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
import model.Problema;
import util.DbUtil;

/**
 *
 * @author Brenda
 */
public class ProblemaDAO {

    private Connection connection;

    public ProblemaDAO() throws URISyntaxException {
        connection = DbUtil.getConnection();
    }

    // estado 1=activo, 2=terminado falta revision, 3=revisado
    public void addProblema(Problema p) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into problema(idTrabajo,nombre,descripcion) values (?,?,?)");
        preparedStatement.setInt(1, p.getIdTaR());
        preparedStatement.setString(2, p.getNombre());
        preparedStatement.setString(3, p.getDescripcion());
        preparedStatement.executeUpdate();
    }

    public void deleteProblema(int idProblema) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from problema where idProblema=?");
        preparedStatement.setInt(1, idProblema);
        preparedStatement.executeUpdate();
    }

    public void updateProblema(Problema p) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update problema set idTrabajo=?,nombre=?,descripcion=?" + " where idProblema=?");
        preparedStatement.setInt(1, p.getIdTaR());
        preparedStatement.setString(2, p.getNombre());
        preparedStatement.setString(3, p.getDescripcion());
        preparedStatement.setInt(4, p.getIdProblema());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Problema> getAllProblemas() throws SQLException {
        ArrayList<Problema> problemas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from problema");
        while (rs.next()) {
            Problema p = new Problema();
            p.setIdProblema(rs.getInt("idProblema"));
            p.setIdTaR(rs.getInt("idTrabajo"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));

            problemas.add(p);
        }
        return problemas;
    }

    public Problema getProblemaById(int idProblema) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from problema where idProblema=" + idProblema);
        Problema p = new Problema();
        if (rs.next()) {
            p.setIdProblema(rs.getInt("idProblema"));
            p.setIdTaR(rs.getInt("idTrabajo"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
        }
        return p;
    }
}
