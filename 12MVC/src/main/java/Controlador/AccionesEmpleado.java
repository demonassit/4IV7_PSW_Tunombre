/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
    
    //consultar toda la lista de empleados
    
    public static List<empleados> getAllEmpleados(){
        //primero necesito un array de objetos de empleado
        List<empleados> lista = new ArrayList<empleados>();
        
        
        try{
            Connection con = Conexion.getConection();
            
            String q = "select * from empleados";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                //necesito el objeto del empleado
                //cada fila es un objeto del registro
                empleados e = new empleados();
                //getter y setter
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPais(rs.getString(5));
                //los agrego a mi lista
                lista.add(e);
            }
            System.out.println("Se encontro al empleado");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al consultar el empleado");
            System.out.println(ex.getMessage());
        }
        return lista;
        
    }
    
    
     //buscar por id al empleado
    
    public static empleados buscarEmpleadoporID(int id){
        //necesito el objeto del empleado
                //cada fila es un objeto del registro
                empleados e = new empleados();
        
        
        try{
            Connection con = Conexion.getConection();
            
            String q = "select * from empleados where id =?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                //getter y setter
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPais(rs.getString(5));
                //los agrego a mi lista
                
            }
            System.out.println("Se encontro al empleado");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al consultar el empleado");
            System.out.println(ex.getMessage());
        }
        return e;
        
    }
    
    //consultar toda la lista de empleados
    
    
    
    
     //eliminar por id al empleado
    
    public static int EliminarEmpleado(int id){
        //saber si se hizo o no la sentencia
        int estado = 0;
        
        
        try{
            Connection con = Conexion.getConection();
            
            String q = "delete from empleados where id =?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            estado = ps.executeUpdate();
            
            System.out.println("Se elimino al empleado");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al eliminar el empleado");
            System.out.println(ex.getMessage());
        }
        return estado;
        
    }
    
    //eliminar por id al empleado
    
    public static int ActualizarEmpleado(empleados e){
        //saber si se hizo o no la sentencia
        int estado = 0;
        
        
        try{
            Connection con = Conexion.getConection();
            
            String q = "update empleados set nombre = ?, "
                    + "password = ?, email = ?, pais = ? "
                    + "where id = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPais());
            ps.setInt(5, e.getId());
            
            estado = ps.executeUpdate();
            
            System.out.println("Se actualizo al empleado");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al eliminar el empleado");
            System.out.println(ex.getMessage());
        }
        return estado;
        
    }
    
    
    
    
}
