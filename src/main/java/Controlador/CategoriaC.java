/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.CategoriaDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

/**
 *
 * @author LabingXEON
 */
public class CategoriaC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO c = null;
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/CategoriaC.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO c = null;
        try {
            c = new CategoriaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServicioC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            categorias = c.getAllCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String categoria = request.getParameter("nombre");
        boolean t = true;
        for (Categoria cat : categorias) {
            if (cat.getNombre().equalsIgnoreCase(categoria)) {
                t = false;
                break;
            }
        }
        if (t) {
            try {
                c.addCategoria(categoria);
            } catch (SQLException ex) {
                Logger.getLogger(ServicioC.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("categorias", categoria);
            request.setAttribute("Respuesta", "Ese servicio ya esta creado");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/CategoriaC.jsp");
            rd.forward(request, response);
        }
    }

}
