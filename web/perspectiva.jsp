<%-- 
    Document   : perspectiva
    Created on : 12/09/2016, 20:55:07
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

        <title>Perspectivas</title>

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
                            <h3 class="page-header"><i class="fa fa fa-bars"></i> Perspectivas</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
                                <li><i class="fa fa-bars"></i>Pages</li>
                                <li><i class="fa fa-square-o"></i>Pages</li>
                            </ol>
                        </div>
                    </div>
                    <!-- início-->
                    <section class="panel">
                        <header class="panel-heading">
                            Cadastrar Perspectiva
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="AdicionaPerspectivaServlet" method="post">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="inputEmail1" placeholder="Descrição">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input type="submit" class="btn btn-info" value="Cadastrar" id="cadastrar"/>
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
        <script src="js/funcoes.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.8.3.min.js"></script>
        <!-- nice scroll -->    
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>
