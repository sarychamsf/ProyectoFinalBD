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
 * 4.4 4.7
 *
 * @author Brenda
 */
public class ProblemaC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            TrabajoARealizarDAO t = new TrabajoARealizarDAO();
            ProblemaDAO p = new ProblemaDAO();
            ArrayList<TrabajoARealizar> taR = t.getAllTrabajosARealizar();
            ArrayList<Problema> probl = p.getAllProblemas();
            if (action.equals("create")) {
                request.setAttribute("trabajos", taR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProblemaC.jsp");
                rd.forward(request, response);
            }
            if (action.equals("update")) {
                request.setAttribute("problemas", probl);
                request.setAttribute("trabajos", taR);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProblemaU.jsp");
                rd.forward(request, response);
            }
            if (action.equals("delete")) {
                request.setAttribute("problemas", probl);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProblemaD.jsp");
                rd.forward(request, response);
            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(ProblemaC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProblemaC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT = Integer.parseInt(request.getParameter("idT"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        try {
            ProblemaDAO p = new ProblemaDAO();
            Problema problemaCrear = new Problema();
            problemaCrear.setIdTaR(idT);
            problemaCrear.setNombre(nombre);
            problemaCrear.setDescripcion(descripcion);
            p.addProblema(problemaCrear);
        } catch (URISyntaxException | SQLException ex) {
            Logger.getLogger(ProblemaC.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<TrabajoARealizar> trabajos = new ArrayList();

        TrabajoARealizarDAO t = null;
        try {
            t = new TrabajoARealizarDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProblemaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            trabajos = t.getAllTrabajosARealizar();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemaC.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("trabajos", trabajos);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProblemaC.jsp");
        rd.forward(request, response);
    }

}
