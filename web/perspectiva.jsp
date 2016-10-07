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
                    <p id="sucess"></p>
                    <!-- início-->
                    <section class="panel">
                        <header class="panel-heading">
                            Cadastrar Perspectiva
                        </header>
                        <div class="panel-body">
                            <!--<form class="form-horizontal" role="form" action="AdicionaPerspectivaServlet" method="post">-->
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="inputEmail1" class="col-lg-2 control-label">Descrição</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="descricao" class="form-control" id="id_descricao" placeholder="Descrição">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-info" id="cadastrar" onclick="cadastraPerspectiva()">Cadastrar</button>
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
        <script type="text/javascript">
            //Função para enviar requisições HTTP
            function initXHR() {
                // criando xhr de acordo com o browser
                if (window.XMLHttpRequest) { // Nao microsoft
                    xhr = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    xhr = new ActiveXObject("Microsoft.XMLHttp");
                }
            }
            //Este codigo e o initXHR sempre serão os mesmo. Não há necessidade de criar outro
            function sendRequest(url, handler) {
                initXHR();
                // setando método de resposta no xhr
                xhr.onreadystatechange = handler;
                // abrindo requisição
                xhr.open("GET", url, true);
                // executando xhr
                xhr.send(null);
            }
            //Função será executada ao Clicar no botão Salvar. A função pega os valores digitados e envia para Servlet
            /*function cadastraPerspectiva() {
             var descricao = document.getElementById("id_descricao");
             //alert(descricao.value);
             //Variável que passará os valores via Ajax para o servlet
             //var url = "AdicionaPerspectivaServlet?descricao=" + descricao.value + ";
             //Envia a varivável e chama proxima função para verificar a resposta do Servlet
             sendRequest(url, ajaxCadastro);
             }*/

            function cadastraPerspectiva() {
                //var descricao = document.getElementById("id_descricao");
                $.ajax({
                    url: "AdicionaPerspectivaServlet",
                    type: "POST",
                    data: {
                        descricao: document.getElementById("id_descricao")
                    },
                    //dataType: "json",
                    error: function () {
                        alert("ERRO")
                    },
                    success: function (responseText) {
                        alert("show");
                    }
                });

            }
            //Retorno do Servlet indicando se está tudo Ok.
            function ajaxCadastro() {
                if (xhr.readyState == 4) { // requisicao concluida
                    // status da resposta 200 = OK, (404 página não encontrada, 500 erro no servidor)
                    if (xhr.status == 200) {
                        alert("show");
                        // setando valores de resposta do servlet no meu div
                        var resposta = document.getElementById("sucess");
                        //Definindo um texto que será exibido se cadastro foi feito com sucesso.
                        resposta.innerHTML = "Perspectiva cadastrada cadastrado com sucesso!";
                    }
                }
            }

        </script>
        <script src="js/jquery.js"></script>
        <script src="js/funcoes.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.8.3.min.js"></script>
        <!-- nice scroll -->    
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
        <script src="js/scripts.js"></script>
    </body>
</html>
