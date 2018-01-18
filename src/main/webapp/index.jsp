<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Index</title>
        <!--
        Ocean Theme
        
        http://www.templatemo.com/tm-484-ocean
        -->

        <!-- load stylesheets -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>

    <body>

        <div class="container-fluid">

            <div class="row"> 

                <section class="tm-section-intro">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="tm-wrapper-center">
                            <h1 class="tm-section-intro-title">Bienvenido</h1>
                            <form align="center" action="Login" method="GET" class="tm-contact-form"> 
                                <%
                                if (request.getAttribute("respuesta") != null) {
                                    %><h6 class="tm-2-col-text-description">Usuario o Contrasena invalidos</h6><%
                                } else {
                                %>
                                <br>
                                <%}%>
                                <label align="center" for="usuario">Usuario</label>
                                <input type="text" name="usuario" maxlength="30" class="form-control" placeholder="máx. 30"  required/>
                                <br>
                                <label align="center" for="login">Password</label>
                                <input type="pass" name="pass" maxlength="30" class="form-control" placeholder="máx. 30"  required/>
                                <br>
                                <button type="submit" class="btn tm-bordered-btn pull-xs-center">Empezar</button>
                            </form>
                        </div>            
                    </div>
                </section>    

            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <p class="text-xs-center tm-copyright-text">Sara Chamseddine © (2017)</p>
                </div>
            </div>

        </div>      

    </body>
</html>
