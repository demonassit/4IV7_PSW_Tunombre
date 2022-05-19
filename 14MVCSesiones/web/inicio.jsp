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
        
        /*
        Aqui es donde necesito consultar la bitacora 
        
        select equipo_etiqueta, lab_nom, marca_nom, cpu_serial,  
            config_descripcionMause, config_descripcionTeclado, monitor_descripcion, 
            config_descripcion, edoEquipo_tipo, problema
            from dequipo as eq
            inner join claboratorio as la
            ON (la.lab_id = eq.lab_id)
            inner join cmarca as ma
            ON (eq.marca_id = ma.marca_id)
            inner join maccesorio as mac
            ON(eq.accesorio_id = mac.accesorio_id)
            inner join mmonitor as mo
            ON(eq.monitor_id = mo.monitor_id )
            inner join mconfiguracion as con
            on(eq.config_id = con.config_id)
            inner join cedoequipo as edo
            on(eq.edoEquipo_id = edo.edoEquipo_id);
        
        */
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
