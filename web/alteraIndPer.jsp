<%-- 
    Document   : alteraIndPer
    Created on : 15/11/2016, 23:40:41
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Indicadores por Período</title>

        <!-- Bootstrap CSS -->    
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/elegant-icons-style.css" rel="stylesheet" />
        <link href="css/font-awesome.min.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet" />
    </head>

    <body>
        <jsp:include page="/header.jsp" />
        <jsp:include page="/menuLateral.jsp" />
        <%
            int objetivo = Integer.parseInt(request.getParameter("objetivo"));
            int indicador = Integer.parseInt(request.getParameter("indicador"));
            int periodo = Integer.parseInt(request.getParameter("periodo"));
            String meta = request.getParameter("meta");
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
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Indicador por Período</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Página Inicial</a></li>
                                <li><i class="fa fa-bars"></i>Cadastros</li>
                                <li><i class="fa fa-square-o"></i>Indicador por Período</li>
                            </ol>
                        </div>
                    </div>
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            Alterar Indicador por Período
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
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
                                    <label for="inputEmail1" class="col-lg-2 control-label">Meta</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="meta" class="form-control" id="id_meta" value="<%=meta%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Valor</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="valor" class="form-control" id="id_valor" value="<%=valor%>">
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
                                        <input class="btn btn-info" type="button" value="Alterar" onclick="alteraIndPer(id_indicador.value,
                                                    id_objetivo.value, id_periodo.value, id_meta.value, id_valor.value, id_descricao.value)"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </section>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
        </section>
        <!-- container section end -->
        <!-- javascripts -->
        <script src="js/jquery.js"></script>
        <script src="js/funcoesIndPer.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
