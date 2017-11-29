/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.QuejaDAO;
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
import javax.servlet.http.HttpSession;
import model.CartQuejas;
import model.Queja;
import model.Trabajador;

/**
 *
 * @author Brenda
 */
public class QuejaM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idQ = request.getParameter("idQ");

        HttpSession session = request.getSession();
        CartQuejas shoppingCart;
        shoppingCart = (CartQuejas) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new CartQuejas();
            session.setAttribute("cart", shoppingCart);
        }

        //QuejaDAO q = new QuejaDAO();
        shoppingCart.deleteFromCart(idQ);
        session.setAttribute("cart", shoppingCart);
        //q.addQueja(quejaCrear);

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idQ = Integer.parseInt(request.getParameter("idQ"));
        int idU = Integer.parseInt(request.getParameter("idU"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        QuejaDAO q = null;
        try {
            q = new QuejaDAO();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuejaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        Queja quejaModificar = new Queja();
        try {
            quejaModificar = q.getQuejaById(idQ);
        } catch (SQLException ex) {
            Logger.getLogger(QuejaM.class.getName()).log(Level.SEVERE, null, ex);
        }

        quejaModificar.setIdUsuario(idU);

        quejaModificar.setNombre(nombre);
        quejaModificar.setDescripcion(descripcion);
        try {
            q.updateQueja(quejaModificar);
        } catch (SQLException ex) {
            Logger.getLogger(QuejaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.jsp");
    }
}
