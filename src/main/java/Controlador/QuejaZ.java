package Controlador;

import dao.QuejaDAO;
import dao.TrabajadorDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class QuejaZ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idQ = Integer.parseInt(request.getParameter("idQ"));
        QuejaDAO q = null;
        try {
            q = new QuejaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuejaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            q.deleteQueja(idQ);
        } catch (SQLException ex) {
            Logger.getLogger(QuejaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartQuejas shoppingCart;
        shoppingCart = (CartQuejas) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new CartQuejas();
            session.setAttribute("cart", shoppingCart);
        }

        QuejaDAO q;
        try {
            q = new QuejaDAO();

            HashMap<String, Queja> items = shoppingCart.getCartQuejas();

            for (String key : items.keySet()) {
                q.addQueja(items.get(key));
            }

        } catch (URISyntaxException | SQLException ex) {
            Logger.getLogger(QuejaZ.class.getName()).log(Level.SEVERE, null, ex);
        }

        shoppingCart = new CartQuejas();
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
