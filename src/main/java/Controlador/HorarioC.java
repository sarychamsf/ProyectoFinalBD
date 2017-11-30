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
        try {
            if (request.getSession().getAttribute("trabajador") != null) {
                if (request.getAttribute("confirmado") != null) {
                    if (!(request.getParameter("horaI1")).equals("-") && !(request.getParameter("horaI2")).equals("-")
                            && !(request.getParameter("horaF1")).equals("-") && !(request.getParameter("horaF2")).equals("-")
                            && !(request.getParameter("fechaD")).equals("-") && !(request.getParameter("fechaM")).equals("-")
                            && !(request.getParameter("fechaA")).equals("-")) {
                        int idU = Integer.parseInt(request.getParameter("idU"));
                        int idT = (int) request.getSession().getAttribute("trabajador");
                        String horaInicial = request.getParameter("horaI1") + "" + request.getParameter("horaI2");
                        int horaI = Integer.parseInt(horaInicial);
                        String horaFinal = request.getParameter("horaF1") + "" + request.getParameter("horaF2");
                        int horaF = Integer.parseInt(horaFinal);
                        String fecha = request.getParameter("fechaD") + "/" + request.getParameter("fechaM") + "/" + request.getParameter("fechaA");
                        HorarioDAO h = new HorarioDAO();
                        Horario horario = new Horario(0, idT, idU, horaI, horaF, fecha, 0);
                        ArrayList<Horario> trabajosE = (ArrayList<Horario>) request.getSession().getAttribute("trabajosE");
                        for(Horario ho:trabajosE){
                            ho.setIdTaR(idT);
                            h.addHorario(ho);
                        }
                        h.addHorario(horario);
                        request.getSession().setAttribute("trabajador", null);
                        request.getSession().setAttribute("trabajosE", null);
                        response.sendRedirect("menu.jsp");
                    } else {
                        TrabajoARealizarDAO t= new TrabajoARealizarDAO();
                        ArrayList<TrabajoARealizar> trabajos=t.getAllTrabajosARealizar();
                        request.setAttribute("respuesta", "aqui hay algo");
                        request.setAttribute("trabajos", trabajos);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    if (!(request.getParameter("horaI1")).equals("-") && !(request.getParameter("horaI2")).equals("-")
                            && !(request.getParameter("horaF1")).equals("-") && !(request.getParameter("horaF2")).equals("-")
                            && !(request.getParameter("fechaD")).equals("-") && !(request.getParameter("fechaM")).equals("-")
                            && !(request.getParameter("fechaA")).equals("-")) {
                        int idU = Integer.parseInt(request.getParameter("idU"));
                        String horaInicial = request.getParameter("horaI1") + "" + request.getParameter("horaI2");
                        int horaI = Integer.parseInt(horaInicial);
                        String horaFinal = request.getParameter("horaF1") + "" + request.getParameter("horaF2");
                        int horaF = Integer.parseInt(horaFinal);
                        String fecha = request.getParameter("fechaD") + "/" + request.getParameter("fechaM") + "/" + request.getParameter("fechaA");
                        HorarioDAO h = new HorarioDAO();
                        Horario horario = new Horario(0, 0, idU, horaI, horaF, fecha, 0);
                        if (request.getSession().getAttribute("trabajosE") == null) {
                            ArrayList<Horario> trabajosE = new ArrayList<>();
                            trabajosE.add(horario);
                            request.getSession().setAttribute("trabajosE", trabajosE);
                        } else {
                            ArrayList<Horario> trabajosE = (ArrayList<Horario>) request.getSession().getAttribute("trabajosE");
                            trabajosE.add(horario);
                            request.getSession().setAttribute("trabajosE", trabajosE);
                        }
                        TrabajoARealizarDAO t= new TrabajoARealizarDAO();
                        ArrayList<TrabajoARealizar> trabajos=t.getAllTrabajosARealizar();
                        request.setAttribute("trabajos", trabajos);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
                        rd.forward(request, response);
                    } else {
                        TrabajoARealizarDAO t= new TrabajoARealizarDAO();
                        ArrayList<TrabajoARealizar> trabajos=t.getAllTrabajosARealizar();
                        request.setAttribute("respuesta", "aqui hay algo");
                        request.setAttribute("trabajos", trabajos);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
                        rd.forward(request, response);
                    }

                }

            } else {

                request.getSession().setAttribute("trabajador", request.getAttribute("idU"));
                ArrayList<TrabajoARealizar> trabajos = new ArrayList();
                TrabajoARealizarDAO t = new TrabajoARealizarDAO();
                try {
                    trabajos = t.getAllTrabajosARealizar();
                } catch (SQLException ex) {
                    Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("trabajos", trabajos);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
                rd.forward(request, response);

            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
