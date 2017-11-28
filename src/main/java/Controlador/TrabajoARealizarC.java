package Controlador;

import dao.EmpresaClienteDAO;
import dao.ServicioDAO;
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
import model.EmpresaCliente;
import model.Servicio;
import model.TrabajoARealizar;
import util.Trabajillo;

public class TrabajoARealizarC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            ServicioDAO s = null;
            try {
                s = new ServicioDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Servicio> servicios = new ArrayList<>();
            try {
                servicios = s.getAllServicios();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("servicios", servicios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRC.jsp");
            rd.forward(request, response);
        }
        TrabajoARealizarDAO t = null;
        try {
            t = new TrabajoARealizarDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<TrabajoARealizar> trabajos = new ArrayList<>();
        try {
            trabajos = t.getAllTrabajosARealizar();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("trabajos", trabajos);
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idS = Integer.parseInt(request.getParameter("idS"));
        int urgencia = Integer.parseInt(request.getParameter("urgencia"));
        String detalles = request.getParameter("detalles");
        try {
            ServicioDAO s = new ServicioDAO();
            ArrayList<Servicio> servicios = s.getAllServicios();
            for (Servicio ser : servicios) {
                if (ser.getIdServicio() == idS) {
                    Trabajillo traba = new Trabajillo(idS, ser.getNombreS(), urgencia, detalles);
                    if (request.getSession().getAttribute("trabajosE") == null) {
                        ArrayList<Trabajillo> trabajosE = new ArrayList<>();
                        trabajosE.add(traba);
                        request.getSession().setAttribute("trabajosE", trabajosE);
                    } else {
                        ArrayList<Trabajillo> trabajosE = (ArrayList<Trabajillo>) request.getSession().getAttribute("trabajosE");
                        trabajosE.add(traba);
                        request.getSession().setAttribute("trabajosE", trabajosE);
                    }
                    request.setAttribute("servicios", servicios);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRC.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.jsp");
    }

}
