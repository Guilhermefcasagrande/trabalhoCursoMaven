<%-- 
    Document   : alteraIndicador
    Created on : 15/11/2016, 22:14:44
    Author     : Guilherme
--%>

<%@page import="Controle.ObjetivoDB"%>
<%@page import="Modelo.Objetivo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Indicadores</title>

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
            String descricao = request.getParameter("descricao");
            String situacao = request.getParameter("situacao");
        %>
        <!-- container section start -->
        <section id="container" class="">

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Indicador</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Página Inicial</a></li>
                                <li><i class="fa fa-bars"></i>Cadastros</li>
                                <li><i class="fa fa-square-o"></i>Indicador</li>
                            </ol>
                        </div>
                    </div>
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            Alterar Indicador
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Código</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_codigo" value="<%=indicador%>" disabled>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" value="<%=descricao%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Situação</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="situação" class="form-control" id="id_situacao" value="<%=situacao%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Objetivo</label>
                                    <div class="col-lg-10">
                                        <select class="form-control m-bot15" name="objetivo" id="id_objetivo">
                                            <%
                                                ArrayList<Objetivo> lista = new ArrayList();
                                                lista = ObjetivoDB.listaObjetivo();

                                                for (int i = 0; i < lista.size(); i++) {
                                                    Objetivo obj = lista.get(i);
                                                    out.println("<option value=" + obj.getObjCodigo() + ">" + obj.getDescricao() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" type="button" value="Alterar" onclick="alteraInd(id_codigo.value, id_descricao.value, id_situacao.value, id_objetivo.value)"/>
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
        <script src="js/funcoesIndicador.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
