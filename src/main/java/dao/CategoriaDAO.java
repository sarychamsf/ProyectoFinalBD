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
import model.Categoria;
import model.Servicio;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO() throws URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public void addCategoria(String s) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into categoria(nombre) values (?)");
        preparedStatement.setString(1, s);
        preparedStatement.executeUpdate();
    }
    
    public ArrayList<Categoria> getAllCategoria() throws SQLException {
        ArrayList<Categoria> categoria = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from categoria");
        while (rs.next()) {
            Categoria c = new Categoria();
            c.setIdCategoria(rs.getInt("idc"));
            c.setNombre(rs.getString("nombre"));
            categoria.add(c);
        }
        return categoria;
    }
}
