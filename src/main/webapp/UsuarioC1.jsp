<%@page import="java.util.ArrayList"%>
<%@page import="model.Trabajador"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.TrabajosTerminados"%>
<%
    HttpSession sesion = request.getSession();
    Trabajador usuario = (Trabajador)sesion.getAttribute("usuario");
    if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Trabajos terminados de los trabajadores activos</title>
        <!--
        Ocean Theme
        http://www.templatemo.com/tm-484-ocean
        -->

        <!-- load stylesheets -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/proyecto.css">                    <!-- Templatemo style -->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>

    <body>
        <div class="container">
            <h2>Trabajos Terminados de los Trabajadores Activos</h2>
            <!--Table-->
            <table class="table">

                <!--Table head-->
                <thead class="blue-grey lighten-4">
                    <tr>
                        <th>idUsuario</th>
                        <th>Nombre</th>
                        <th>Cargo</th>
                        <th>Fecha Terminado</th>
                        <th>Fecha Revisado</th>
                        <th>Hora Inicio</th>
                        <th>Hora Final</th>
                        <th>Fecha</th>
                        <th>Urgencia</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <!--Table head-->
                
                <!--Table body-->
                <tbody>
                    <%
                    if (request.getAttribute("lista") != null) {
                        ArrayList<TrabajosTerminados> array = (ArrayList<TrabajosTerminados>) request.getAttribute("lista");
                            for (TrabajosTerminados t : array) {
                    %>
                    <tr>
                        <td><%= t.getIdUsuario() %></td>
                        <td><%= t.getNombre() %></td>
                        <td><%= t.getCargo() %></td>
                        <td><%= t.getFechaTerminado() %></td>
                        <td><%= t.getFechaRevisado() %></td>
                        <td><%= t.getHoraInicio() %></td>
                        <td><%= t.getHoraFinal() %></td>
                        <td><%= t.getFecha() %></td>
                        <td><%= t.getUrgencia() %></td>
                        <td><%= t.getDetalles() %></td>

                    </tr>

                    <%      }
                        }
                    %>
                </tbody>
                <!--Table body-->
            </table>
            <!--Table-->
            <p class="text-center">
                <a class="btn tm-bordered-btn pull-xs-center" href="menu.jsp" role="button">Volver</a>
            </p>
        </div>

    </body>
</html>
<%}%>
