package Controlador;

import dao.QuejaDAO;
import dao.TrabajadorDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartQuejas;
import model.Queja;
import model.Trabajador;

/**
 *
 * @author Brenda
 */
public class QuejaC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("delete")) {
            QuejaDAO q = null;
            try {
                q = new QuejaDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(QuejaC.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Queja> quejas = new ArrayList();
            try {
                quejas = q.getAllQuejas();
            } catch (SQLException ex) {
                Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("quejas", quejas);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuejaD.jsp");
            rd.forward(request, response);
        }

        TrabajadorDAO t = null;
        try {
            t = new TrabajadorDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuejaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Trabajador> trabajadores = new ArrayList();

        QuejaDAO q = null;
        try {
            q = new QuejaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuejaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Queja> quejas = new ArrayList();
        try {
            trabajadores = t.getAllTrabajadores();
            quejas = q.getAllQuejas();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (action.equals("create")) {
            request.setAttribute("trabajadores", trabajadores);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuejaC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            request.setAttribute("quejas", quejas);
            request.setAttribute("trabajadores", trabajadores);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuejaU.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("idU"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        HttpSession session = request.getSession();
        CartQuejas shoppingCart;
        shoppingCart = (CartQuejas) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new CartQuejas();
            session.setAttribute("cart", shoppingCart);
        }

        //QuejaDAO q = new QuejaDAO();
        Queja quejaCrear = new Queja();
        quejaCrear.setIdQueja(UUID.randomUUID().hashCode());
        quejaCrear.setIdUsuario(idU);
        quejaCrear.setNombre(nombre);
        quejaCrear.setDescripcion(descripcion);
        shoppingCart.addToCart(quejaCrear.getIdQueja() + "", quejaCrear);
        //q.addQueja(quejaCrear);
        session.setAttribute("cart", shoppingCart);

        ArrayList<Trabajador> trabajadores = new ArrayList();

        TrabajadorDAO t = null;
        try {
            t = new TrabajadorDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuejaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            trabajadores = t.getAllTrabajadores();
        } catch (SQLException ex) {
            Logger.getLogger(QuejaC.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("trabajadores", trabajadores);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuejaC.jsp");
        rd.forward(request, response);
    }

}
