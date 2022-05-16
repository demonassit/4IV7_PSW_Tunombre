<%-- 
    Document   : inicio
    Created on : 16/05/2022, 04:29:50 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String usuario = "";
    //creamos una sesion para verificar que exista en la BD
    HttpSession sesionusu = request.getSession();
    
    //obtenemos el atributo de la sesion que viene del setvlet
    if(sesionusu.getAttribute("usuario")==null){
    //cuando no existe el usuario
    
    %>
    <jsp:forward page="index.html" >
        <jsp:param name="error" value="Es obligatorio inicar sesión"/>
    </jsp:forward>
    
    
    <%
    }else{
        //si hay una sesion pq existe en la bd
        usuario = (String)sesionusu.getAttribute("usuario");
    }

    %>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        encabezado
        
        menu
        
        <h1>Si existes T_T</h1>
        
        <%
        //obtener los privilegios  == 1    
        %>
        
        
        
        <%
        //obtener los privilegios  == 2    
        %>
        
        
        <%
        //obtener los privilegios  == 3    
        %>
        
        
        patitas
    </body>
</html>
