<%-- 
    Document   : indicadorPeriodo
    Created on : 14/11/2016, 09:38:13
    Author     : Guilherme
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

        <title>Indicadores por Período</title>

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
                            Cadastrar Indicador por Período
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
                                    <label for="inputEmail1" class="col-lg-2 control-label">Meta</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="meta" class="form-control" id="id_meta" placeholder="Meta">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Valor</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="valor" class="form-control" id="id_valor" placeholder="Valor">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" placeholder="Descrição">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input class="btn btn-info" id="cadastrar" type="button" value="Cadastrar" />
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

        <script type="text/javascript">
            $("#cadastrar").click(function () {
                $.ajax({
                    url: "AdicionaIndPerServlet",
                    type: "POST",
                    data: {
                        "indicador": $('#id_indicador').val(),
                        "objetivo": $('#id_objetivo').val(),
                        "periodo": $('#id_periodo').val(),
                        "meta": $('#id_meta').val(),
                        "valor": $('#id_valor').val(),
                        "descricao": $('#id_descricao').val()
                    },
                    error: function () {
                        alert("Não foi possível cadastrar o Indicador por Período. Contate o Administrador do sistema.");
                    },
                    success: function (responseText) {
                        alert(responseText);
                        $('#form').each(function () {
                            this.reset();
                        });
                    }
                });
            });
        </script>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- nice scroll -->
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>
