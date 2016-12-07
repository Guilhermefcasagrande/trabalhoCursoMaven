<%-- 
    Document   : alteraLocal
    Created on : 15/11/2016, 23:05:12
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Local</title>

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
            int local = Integer.parseInt(request.getParameter("codigo"));
            String descricao = request.getParameter("descricao");
            String tipo = request.getParameter("tipo");
        %>
        <!-- container section start -->
        <section id="container" class="">

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Local</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Página Inicial</a></li>
                                <li><i class="fa fa-bars"></i>Cadastros</li>
                                <li><i class="fa fa-square-o"></i>Local</li>
                            </ol>
                        </div>
                    </div>
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            Alterar Local
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Código</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_local" value="<%=local%>" disabled>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" value="<%=descricao%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Tipo</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="tipo" class="form-control" id="id_tipo" value="<%=tipo%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" type="button" value="Alterar" onclick="alteraLoc(id_local.value, id_descricao.value, id_tipo.value)"/>
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
        <script src="js/funcoesLocal.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
