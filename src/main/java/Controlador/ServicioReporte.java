/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.CategoriaDAO;
import dao.ServicioDAO;
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
import model.ReporteServicio;

/**
 *
 * @author LabingXEON
 */
public class ServicioReporte extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ServicioDAO s = new ServicioDAO();
            ArrayList<ReporteServicio> reportes = s.getReporteServicios();
            request.setAttribute("reporte", reportes);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioReporte.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServicioReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
