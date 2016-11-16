<%-- 
    Document   : alteraMedicao
    Created on : 16/11/2016, 12:36:27
    Author     : admin
--%>

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

        <title>Acompanhamento</title>

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
        <%
            int local = Integer.parseInt(request.getParameter("local"));
            int plano = Integer.parseInt(request.getParameter("plano"));
            int periodo = Integer.parseInt(request.getParameter("periodo"));
            int indicador = Integer.parseInt(request.getParameter("indicador"));
            int objetivo = Integer.parseInt(request.getParameter("objetivo"));
            String valor = request.getParameter("valor");
            String descricao = request.getParameter("descricao");
        %>
        <!-- container section start -->
        <section id="container" class="">

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Acompanhamento</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
                                <li><i class="fa fa-bars"></i>Cadastros</li>
                                <li><i class="fa fa-square-o"></i>Acompanhamento</li>
                            </ol>
                        </div>
                    </div>
                    <p id="sucess"></p>
                    <!-- início-->
                    <section class="panel">
                        <header class="panel-heading">
                            Cadastrar Acompanhamento
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Plano</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="indicador" class="form-control" id="id_plano" value="<%=plano%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Indicador</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="indicador" class="form-control" id="id_indicador" value="<%=indicador%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Objetivo</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="objetivo" class="form-control" id="id_objetivo" value="<%=objetivo%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Período</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="periodo" class="form-control" id="id_periodo" value="<%=periodo%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Local</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="local" class="form-control" id="id_local" value="<%=local%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Valor</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_valor" value="<%=valor%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" value="<%=descricao%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" type="button" value="Cadastrar" onclick="alteraAcomp(id_plano.value, id_local.value, id_indicador.value, 
                                                    id_objetivo.value, id_periodo.value, id_valor.value, id_descricao.value)"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </section>
                    <!-- fim-->
                </section>
            </section>
            <!--main content end-->
        </section>

        <!-- javascripts -->
        <script src="js/jquery.js"></script>
        <script src="js/funcoesAcomp.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.8.3.min.js"></script>
        <!-- nice scroll -->    
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>
