<%-- 
    Document   : objetivo
    Created on : 12/09/2016, 20:55:52
    Author     : Guilherme
--%>

<%@page import="Controle.PerspectivaDB"%>
<%@page import="Modelo.Perspectiva"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
        <meta name="author" content="GeeksLabs">
        <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Objetivos</title>

        <!-- Bootstrap CSS -->    
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <!--external css-->
        <!-- font icon -->
        <link href="css/elegant-icons-style.css" rel="stylesheet" />
        <link href="css/font-awesome.min.css" rel="stylesheet" />
        <!-- Custom styles -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet" />
    </head>

    <body>
        <jsp:include page="/header.jsp" />
        <jsp:include page="/menuLateral.jsp" />
        <!-- container section start -->
        <section id="container" class="">

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Objetivos</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Página Inicial</a></li>
                                <li><i class="fa fa-bars"></i>Cadastros</li>
                                <li><i class="fa fa-square-o"></i>Objetivos</li>
                            </ol>
                        </div>
                    </div>
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            Cadastrar Objetivo
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" placeholder="Descrição">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Perspectiva</label>
                                    <div class="col-lg-10">
                                        <select class="form-control m-bot15" name="perspectiva" id="id_perspectiva">
                                            <%
                                                ArrayList<Perspectiva> lista = new ArrayList();
                                                lista = PerspectivaDB.listaPerspectiva();

                                                for (int i = 0; i < lista.size(); i++) {
                                                    Perspectiva persp = lista.get(i);
                                                    out.println("<option value=" + persp.getPrsCodigo() + ">" + persp.getDescricao() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" id="cadastrar" type="button" value="Cadastrar" onclick="lista()"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </section>

                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Listagem de Objetivos
                                </header>

                                <table class="table table-striped table-advance table-hover" id="listaPersp">
                                    <thead>
                                        <tr>
                                            <th><i class="icon_profile"></i> Código</th>
                                            <th><i class="icon_calendar"></i> Descrição</th>
                                            <th><i class="icon_calendar"></i> Perspectiva</th>
                                            <th><i class="icon_calendar"></i> Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody id="result">
                                        <!-- Resultado-->
                                    </tbody>
                                </table>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
        </section>
        <!-- container section end -->
        <!-- javascripts -->

        <script type="text/javascript">

        </script>
        <script src="js/funcoesObjetivos.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- nice scroll -->
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>