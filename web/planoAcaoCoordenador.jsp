<%-- 
    Document   : planoAcaoCoordenador
    Created on : 15/10/2016, 17:56:43
    Author     : Guilherme
--%>

<%@page import="Controle.LocalDB"%>
<%@page import="Modelo.Local"%>
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
                                    <label for="inputEmail1" class="col-lg-2 control-label">Indicador</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="indicador" class="form-control" id="id_indicador" placeholder="Indicador">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Objetivo</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="objetivo" class="form-control" id="id_objetivo" placeholder="Objetivo">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Período</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="periodo" class="form-control" id="id_periodo" placeholder="Período">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Local</label>
                                    <div class="col-lg-10">
                                        <select class="form-control m-bot15" name="local" id="id_local">
                                            <%
                                                ArrayList<Local> lista = new ArrayList();
                                                lista = LocalDB.listaLocal();

                                                for (int i = 0; i < lista.size(); i++) {
                                                    Local loc = lista.get(i);
                                                    out.println("<option value=" + loc.getLocCodigo() + ">" + loc.getDescricao() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" placeholder="Descrição">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Meta</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="meta" class="form-control" id="id_meta" placeholder="Meta">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Prazo</label>
                                    <div class="col-lg-10">
                                        <input type="date" name="prazo" class="form-control" id="id_prazo" placeholder="Prazo">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Situação</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="situacao" class="form-control" id="id_situacao" placeholder="Situação">
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
                                            <th><i class="icon_profile"></i> Plano</th>
                                            <th><i class="icon_calendar"></i> Local</th>
                                            <th><i class="icon_calendar"></i> Indicador</th>
                                            <th><i class="icon_calendar"></i> Objetivo</th>
                                            <th><i class="icon_calendar"></i> Período</th>
                                            <th><i class="icon_calendar"></i> Descrição</th>
                                            <th><i class="icon_calendar"></i> Meta</th>
                                            <th><i class="icon_calendar"></i> Prazo</th>
                                            <th><i class="icon_calendar"></i> Situação</th>
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
