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
        if (request.getSession().getAttribute("trabajador") != null) {
//            if (request.getAttribute("confirmado") != null) {
//            } else {
//                if (!(request.getParameter("horaI1")).equals("-") && !(request.getParameter("horaI2")).equals("-")
//                        && !(request.getParameter("horaF1")).equals("-") && !(request.getParameter("horaF2")).equals("-")
//                        && !(request.getParameter("fechaD")).equals("-") && !(request.getParameter("fechaM")).equals("-")
//                        && !(request.getParameter("fechaA")).equals("-")) {
//                    int idT = Integer.parseInt(request.getParameter("idT"));
//                    int idU = Integer.parseInt(request.getParameter("idU"));
//                    String horaInicial = request.getParameter("horaI1") + "" + request.getParameter("horaI2");
//                    int horaI = Integer.parseInt(horaInicial);
//                    String horaFinal = request.getParameter("horaF1") + "" + request.getParameter("horaF2");
//                    int horaF = Integer.parseInt(horaFinal);
//                    String fecha = request.getParameter("fechaD") + "/" + request.getParameter("fechaM") + "/" + request.getParameter("fechaA");
//                    HorarioDAO h = null;
//                    try {
//                        h = new HorarioDAO();
//                    } catch (URISyntaxException ex) {
//                        Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    Horario horario = new Horario(0, idT, idU, horaI, horaF, fecha, 0);
//                    try {
//                        h.addHorario(horario);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    response.sendRedirect("menu.jsp");
//                } else {
//                    TrabajadorDAO u = null;
//                    try {
//                        u = new TrabajadorDAO();
//                    } catch (URISyntaxException ex) {
//                        Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    ArrayList<Trabajador> usuarios = new ArrayList<>();
//                    TrabajoARealizarDAO t = null;
//                    try {
//                        t = new TrabajoARealizarDAO();
//                    } catch (URISyntaxException ex) {
//                        Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    ArrayList<TrabajoARealizar> trabajos = new ArrayList();
//                    try {
//                        trabajos = t.getAllTrabajosARealizar();
//                        usuarios = u.getAllTrabajadores();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    request.setAttribute("respuesta", "aqui hay algo");
//                    request.setAttribute("usuarios", usuarios);
//                    request.setAttribute("trabajos", trabajos);
//                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
//                    rd.forward(request, response);
//                }
//                
//            }
//            if (request.getParameter("confirmado") != null) {
//                ArrayList<Trabajillo> trabajosE = (ArrayList<Trabajillo>) request.getSession().getAttribute("trabajosE");
//                EmpresaCliente e=(EmpresaCliente) request.getSession().getAttribute("empresa");
//                TrabajoARealizarDAO tar=new TrabajoARealizarDAO();
//                for(Trabajillo traba: trabajosE){
//                    TrabajoARealizar t=new TrabajoARealizar(0, e.getNIT(), traba.getIdServicio(), traba.getUrgencia(), traba.getDetalles(), 0);
//                    tar.addTrabajoARealizar(t);
//                }
//                TrabajoARealizar t=new TrabajoARealizar(0, e.getNIT(), idS, urgencia, detalles, 0);
//                tar.addTrabajoARealizar(t);
//                request.getSession().setAttribute("trabajosE", null);
//                response.sendRedirect("menu.jsp");
//            } else {
//                ArrayList<Servicio> servicios = s.getAllServicios();
//                for (Servicio ser : servicios) {
//                    if (ser.getIdServicio() == idS) {
//                        Trabajillo traba = new Trabajillo(idS, ser.getNombreS(), urgencia, detalles);
//                        if (request.getSession().getAttribute("trabajosE") == null) {
//                            ArrayList<Trabajillo> trabajosE = new ArrayList<>();
//                            trabajosE.add(traba);
//                            request.getSession().setAttribute("trabajosE", trabajosE);
//                        } else {
//                            ArrayList<Trabajillo> trabajosE = (ArrayList<Trabajillo>) request.getSession().getAttribute("trabajosE");
//                            trabajosE.add(traba);
//                            request.getSession().setAttribute("trabajosE", trabajosE);
//                        }
//                        request.setAttribute("servicios", servicios);
//                        request.setAttribute("DSFOIJ", "asdfqwef");
//                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRC.jsp");
//                        rd.forward(request, response);
//                    }
//                }
//            }
        } else {
            response.sendRedirect("/menu.jsp");
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
}
