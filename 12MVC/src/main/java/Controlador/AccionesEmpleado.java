/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.*;
import modelo.empleados;

/**
 *
 * @author Alumno
 * 
 * Esta clase son los metodos de acceso a la informacion
 */
public class AccionesEmpleado {
    
    //CRUD
    
    //registro
    public static int registroEmpleado(empleados e){
        int estatus = 0;
        
        try{
            //establecer la conexion con la bd
            Connection con = Conexion.getConection();
            String q = "insert into empleados(nombre, password, email, pais)"
                    + " values(?, ?, ?, ?)";
            
            //ahora debo de preparar la sentencia 
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //objeto del empleado
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPais());
            
            //ejecutar la querry
            estatus = ps.executeUpdate();
            
            System.out.println("Registro Exitoso");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al registrar el empleado");
            System.out.println(ex.getMessage());
        
        }
        return estatus;
    }
    
}
