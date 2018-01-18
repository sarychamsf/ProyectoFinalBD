<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Menu</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style https://www.youtube.com/watch?v=wJSeVoyffCY -->

    </head>

    <body>
        <!--git status
            git pull
            git commit -a -m "hola"
            git checkout master
            git checkout -b ramaOtra
            git push
            git push --set-upstream origin ramaOtra-->
        <div class="row tm-section tm-blue-bg-row">

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-xs-center">
                <h2 class="tm-section-title">Menú</h2>   
                <br><br>
            </div>
            
            <div div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-xs-center">

                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Usuario</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="Usuario?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="Usuario?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="Usuario?action=delete" role="button">D</a>
                        <a class="btn btn-primary btn-lg" href="Usuario?action=consulta1" role="button">C1</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Empresa</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="EmpresaC.jsp" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="EmpresaC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="EmpresaC?action=delete" role="button">D</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4" >
                    <h3 align="center" class="tm-icon-text-box-title">Mensaje</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="MensajeC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="MensajeC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="MensajeC?action=delete" role="button">D</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4" >
                    <h3 align="center" class="tm-icon-text-box-title">Servicio</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="ServicioC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="ServicioC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="ServicioC?action=delete" role="button">D</a>
                        <a class="btn btn-primary btn-lg" href="ServicioReporte" role="button">Reporte</a>
                    </p>
                </div>

                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Funciones</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="FuncionesC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="FuncionesC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="FuncionesC?action=delete" role="button">D</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Trabajo a Realizar</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="TrabajoARealizarC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="TrabajoARealizarC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="TrabajoARealizarC?action=delete" role="button">D</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Horario</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="HorarioC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="HorarioC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="HorarioC?action=delete" role="button">D</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Terminado</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="TerminadoC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="TerminadoC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="TerminadoC?action=delete" role="button">D</a>
                    </p>
                </div>

                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Categoria</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="CategoriaC?action=create" role="button">C</a>
                    </p>
                </div>
                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Reporte Mensajes</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="MensajesReporte?action=create" role="button">R</a>
                    </p>
                </div>

                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Problema</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="ProblemaC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="ProblemaC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="ProblemaC?action=delete" role="button">D</a>
                    </p>
                </div>

                <div class="tm-icon-text-box col-md-4">
                    <h3 align="center" class="tm-icon-text-box-title">Queja</h3>
                    <p align="center">
                        <a class="btn btn-primary btn-lg" href="QuejaC?action=create" role="button">C</a>
                        <a class="btn btn-primary btn-lg" href="QuejaC?action=update" role="button">U</a>
                        <a class="btn btn-primary btn-lg" href="QuejaC?action=delete" role="button">D</a>
                    </p>
                </div>



            </div>


            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <p class="text-xs-center tm-copyright-text">Sara Chamseddine © (2017)</p>
                </div>
            </div>

        </div>
    </body>
</html>