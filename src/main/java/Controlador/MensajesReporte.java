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
            ArrayList<Mensaje> mensajes=new ArrayList<>();
            ArrayList<Integer> ya=new ArrayList<>();
            ArrayList<Reporte> r=new ArrayList<>();
            mensajes=m.getAllMensaje();
            for(Mensaje men :mensajes){
                int idU1= men.getIdU1(),enviados=0,recibidos=0;
                String nombre="";
                if(ya.contains(men.getIdU1())){
                    continue;
                }else{
                    ArrayList<Trabajador> trabajadores=new ArrayList<>();
                    TrabajadorDAO t=new TrabajadorDAO();
                    trabajadores=t.getAllTrabajadores();
                    for(Trabajador tra:trabajadores){
                        if(tra.getIdUsuario()==idU1){
                            nombre=tra.getNombre();
                            break;
                        }
                    }
                }
                for(Mensaje men2:mensajes){
                    if(idU1==men2.getIdU1()){
                        enviados++;
                    }
                    if(idU1==men2.getIdU2()){
                        recibidos++;
                    }
                }
                r.add(new Reporte(nombre, enviados, recibidos));
                ya.add(idU1);
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
