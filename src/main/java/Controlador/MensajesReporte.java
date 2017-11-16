/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.MensajeDAO;
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
import model.Mensaje;
import model.Trabajador;
import util.Reporte;


/**
 *
 * @author LabingXEON
 */
public class MensajesReporte extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MensajeDAO m= new MensajeDAO();
            ArrayList<Mensaje> mensajes=m.getAllMensaje();
            TrabajadorDAO t=new TrabajadorDAO();
            ArrayList<Trabajador> trabajadores=t.getAllTrabajadores();
            ArrayList<Reporte> r=new ArrayList<>();
            for(Trabajador tra : trabajadores){
                int idU=tra.getIdUsuario();
                int enviados=0;
                int recibidos=0;
                for(Mensaje men : mensajes){
                    if(idU==men.getIdU1()){
                        enviados++;
                    }
                }
                for(Mensaje men : mensajes){
                    if(idU==men.getIdU2()){
                        recibidos++;
                    }
                }
                if(enviados!=0 || recibidos!=0){
                    r.add(new Reporte(tra.getNombre(), enviados, recibidos));
                }
            }
            request.setAttribute("reporte", r);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Reporte.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MensajesReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MensajesReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
