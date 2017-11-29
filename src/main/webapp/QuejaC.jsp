<%@page import="model.Trabajador"%>
<%@page import="model.Queja"%>
<%@page import="model.CartQuejas"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%
    CartQuejas shoppingCart;
        shoppingCart = (CartQuejas) session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new CartQuejas();
          session.setAttribute("cart", shoppingCart);
        }
        
        HashMap<String, Queja> items = shoppingCart.getCartQuejas();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Agregar Queja</title>
        <!--
        Ocean Theme
        http://www.templatemo.com/tm-484-ocean
        -->

        <!-- load stylesheets -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->
        <link rel="stylesheet" href="css/proyecto.css"> 
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>

    <body>

        <div class="row tm-section">

            <section class="tm-section-contact">

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-xs-center">

                    <h2 class="tm-section-title">Agregar Queja</h2>
                    <br><br>

                </div>
                <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
                    <form align="center" action="QuejaC" method="POST" class="tm-contact-form">
                        <!-- <form align="center" action="QuejaC" method="POST" class="tm-contact-form"> -->
                        <label align="center" for="idU">Trabajador</label>
                        <select name="idU" class="form-control form-control-lg">
                            <%
                                if (request.getAttribute("trabajadores") != null) {
                                    ArrayList<Trabajador> array = (ArrayList<Trabajador>) request.getAttribute("trabajadores");
                                    for (Trabajador t : array) {
                            %>
                            <option value="<%=t.getIdUsuario()%>"><%=t.getNombre()%></option>
                            <%      }
                                }
                            %>
                        </select>  

                        <br>
                        <label align="center" for="nombre">Nombre</label>
                        <input type="text" name="nombre" maxlength="300" class="form-control" placeholder="máx. 300"  required/>
                        <br>
                        <label align="center" for="descripcion">Descripción</label>
                        <input type="text" name="descripcion" maxlength="300" class="form-control" placeholder="máx. 300"  required/>
                        <br>
                        <button type="submit" class="btn tm-bordered-btn pull-xs-center">Agregar</button>
                        <a class="btn tm-bordered-btn pull-xs-center" href="menu.jsp" role="button">Volver</a>
                    </form>  

                </div>                         


            </section>



        </div>

    </div>
    <div class="container">


        <table class="table table-striped">
            <thead>
                <tr>
                    <th class="invisible">Id Queja</th>
                    <th>Id Usuario</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(String key: items.keySet()){
                %>
                <tr>
                    <td class="invisible"><%= items.get(key).getIdQueja() %></td>
                    <td><%= items.get(key).getIdUsuario() %></td>
                    <td><%= items.get(key).getNombre() %></td>
                    <td><%= items.get(key).getDescripcion() %></td>
                    <td>
                        <form align="center" action="QuejaM" method="GET" class="tm-contact-form"> 
                            <input type="text" name="idQ" class="invisible" value="<%= items.get(key).getIdQueja() %>" />
                            <button type="submit" class="btn btn-sm tm-bordered-btn pull-xs-center">Eliminar</button>
                        </form>

                    </td>
                </tr>

                <%
                    }
                %>



            </tbody>


        </table>
        <div class="text-center">
            <form align="center" action="QuejaZ" method="POST" class="tm-contact-form">
                <button type="submit" class="btn btn-sm tm-bordered-btn pull-xs-center">Guardar Quejas</button>
            </form>

        </div>


    </div>



</body>
</html>
