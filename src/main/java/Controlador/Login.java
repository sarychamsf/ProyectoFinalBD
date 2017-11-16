/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.EmpresaClienteDAO;
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

/**
 *
 * @author LabingXEON
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            EmpresaClienteDAO t = new EmpresaClienteDAO();
            ArrayList<EmpresaCliente> empresas = t.getAllEmpresas();
            for (EmpresaCliente e : empresas) {
                if (e.getUsuarioE().equals(usuario) && e.getPasswordE().equals(pass)) {
                    request.getSession().setAttribute("empresa", e);
                    response.sendRedirect("/menu.jsp");
                    return;
                }
            }
            request.setAttribute("respuesta", "asddfpoiqjef");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
