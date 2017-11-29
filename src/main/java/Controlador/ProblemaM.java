/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.ProblemaDAO;
import dao.TrabajoARealizarDAO;
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
import model.Problema;
import model.TrabajoARealizar;

/**
 *
 * @author Brenda
 */
public class ProblemaM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idP = Integer.parseInt(request.getParameter("idP"));
        ProblemaDAO p = null;
        try {
            p = new ProblemaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProblemaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.deleteProblema(idP);
        } catch (SQLException ex) {
            Logger.getLogger(ProblemaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idP = Integer.parseInt(request.getParameter("idP"));
        int idT = Integer.parseInt(request.getParameter("idT"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        ProblemaDAO p = null;
        try {
            p = new ProblemaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProblemaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        Problema problemaModificar = new Problema();
        try {
            problemaModificar = p.getProblemaById(idP);
        } catch (SQLException ex) {
            Logger.getLogger(ProblemaM.class.getName()).log(Level.SEVERE, null, ex);
        }

        problemaModificar.setIdTaR(idT);

        problemaModificar.setNombre(nombre);
        problemaModificar.setDescripcion(descripcion);
        try {
            p.updateProblema(problemaModificar);
        } catch (SQLException ex) {
            Logger.getLogger(ProblemaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.jsp");
    }

}
