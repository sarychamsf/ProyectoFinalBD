package Controlador;

import dao.FuncionesDAO;
import dao.ServicioDAO;
import dao.TrabajadorDAO;
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
import model.Funciones;
import model.Servicio;
import model.Trabajador;

public class FuncionesC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ServicioDAO s = null;
        try {
            s = new ServicioDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Servicio> servicios = new ArrayList<>();
        TrabajadorDAO t = null;
        try {
            t = new TrabajadorDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Trabajador> usuarios = new ArrayList<>();
        try {
            servicios = s.getAllServicios();
            usuarios = t.getAllTrabajadores();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("servicios", servicios);
        if (action.equals("create")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("idU"));
        int idS = Integer.parseInt(request.getParameter("idS"));
        int valoracion = Integer.parseInt(request.getParameter("valoracion"));
        FuncionesDAO f = null;
        try {
            f = new FuncionesDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funciones funcion = new Funciones();
        try {
            funcion = f.getFuncionesByIds(idS, idU);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (funcion != null) {
            ServicioDAO s = null;
            try {
                s = new ServicioDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Servicio> servicios = new ArrayList<>();
            TrabajadorDAO t=null;
            try {
                t = new TrabajadorDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Trabajador> usuarios = new ArrayList<>();
            try {
                servicios = s.getAllServicios();
                usuarios = t.getAllTrabajadores();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("servicios", servicios);
            request.setAttribute("respuesta", "algooo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionC.jsp");
            rd.forward(request, response);
        } else {
            funcion = new Funciones(idU, idS, valoracion);
            try {
                f.addFunciones(funcion);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionesC.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        }

    }
}
