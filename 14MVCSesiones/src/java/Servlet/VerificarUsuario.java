/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.MPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class VerificarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //obtener los parametros
            String user, pass;
            
            user = request.getParameter("txtUsuario");
            pass = request.getParameter("txtPassword");
            
            //creo a persona
            MPersona persona = new MPersona();
            
            //el mismo objeto mando a verificar
            persona = persona.verificarUsuario(user, pass);
            
            //creamos la sesion
            //lo primero cuando el usario si exsite en la bd
            if(persona != null){
                //si existe en la bd 
                HttpSession sesionusu = request.getSession(true);
                //enviamos el atributo de la sesion
                sesionusu.setAttribute("usuario", persona);
                
                //segunda sesion para los parametros
                HttpSession sesionparemtro = request.getSession();
                sesionparemtro.setAttribute("Nombre", user);
                
                //vamos a obtener el privelegio o rol
                /*
                privilegio                 rol
                1 Alumno                    1
                2 Jefe de Grupo
                3 Docente                   2
                4 Jefe de area
                5 Tecnico                   3
                6 Jefe Tecnico
                7 Administrador             4
                */
                
                //aqui va el switch
                if(persona.getPrivilegio_id() == 1 && persona.getRol_id() == 1){
                    response.sendRedirect("inicio_alumno.jsp");
                }else{
                    response.sendRedirect("inicio.jsp");
                }
                
                
            }else{
                //el usuario no se a registradp
                response.sendRedirect("registro.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
