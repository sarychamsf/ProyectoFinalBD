package Controlador;

import dao.HorarioDAO;
import dao.TrabajadorDAO;
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
import model.Horario;
import model.Trabajador;
import model.TrabajoARealizar;

public class HorarioC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("delete")) {
            HorarioDAO h = null;
            try {
                h = new HorarioDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Horario> horarios = new ArrayList();
            try {
                horarios = h.getAllHorarios();
            } catch (SQLException ex) {
                Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("horarios", horarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioD.jsp");
            rd.forward(request, response);
        }
        TrabajadorDAO u = null;
        try {
            u = new TrabajadorDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Trabajador> usuarios = new ArrayList<>();
        TrabajoARealizarDAO t = null;
        try {
            t = new TrabajoARealizarDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<TrabajoARealizar> trabajos = new ArrayList();
        HorarioDAO h = null;
        try {
            h = new HorarioDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Horario> horarios = new ArrayList();
        try {
            trabajos = t.getAllTrabajosARealizar();
            usuarios = u.getAllTrabajadores();
            horarios = h.getAllHorarios();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (action.equals("create")) {
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioE.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            request.setAttribute("horarios", horarios);
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioU.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("trabajador", request.getAttribute("idU"));
        ArrayList<TrabajoARealizar> trabajos = new ArrayList();
        TrabajoARealizarDAO t = null;
        try {
            trabajos = t.getAllTrabajosARealizar();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("trabajos", trabajos);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
        rd.forward(request, response);
    }
}
