<%-- 
    Document   : alteraPlanoAc
    Created on : 16/11/2016, 10:06:34
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

        <title>Plano de ação</title>

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
            String descricao = request.getParameter("descricao");
            String meta = request.getParameter("meta");
            String prazo = request.getParameter("prazo");
            String situacao = request.getParameter("situacao");
        %>
        <!-- container section start -->
        <section id="container" class="">

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Plano de ação</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
                                <li><i class="fa fa-bars"></i>Planos de Ação</li>
                                <li><i class="fa fa-square-o"></i>Plano de ação</li>
                            </ol>
                        </div>
                    </div>
                    <p id="sucess"></p>
                    <!-- início-->
                    <section class="panel">
                        <header class="panel-heading">
                            Cadastrar Plano de Ação
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
                                    <label for="inputEmail1" class="col-lg-2 control-label">Local</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="local" class="form-control" id="id_local" value="<%=local%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" value="<%=descricao%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Meta</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="meta" class="form-control" id="id_meta" value="<%=meta%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Prazo</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="prazo" class="form-control" id="id_prazo" value="<%=meta%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Situação</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="situacao" class="form-control" id="id_situacao" value="<%=situacao%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" type="button" value="Alterar" onclick="alteraPlanoAc(id_local.value, id_descricao.value, 
                                                    id_meta.value, id_prazo.value, id_situacao.value, id_plano.value)"/>
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
        <script src="js/funcoesPlanoAcao.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.8.3.min.js"></script>
        <!-- nice scroll -->    
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>
