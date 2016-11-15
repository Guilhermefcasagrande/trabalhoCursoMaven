/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#disable_acao").click(function () {
        // desabilitando o campo 
        $('#id_descricao_acao').attr("disabled", true);
    });
    $("#able_acao").click(function () {
        // habilitando o campo 
        $('#id_descricao_acao').prop("disabled", false);
    });

    $("#disable_meta").click(function () {
        // desabilitando o campo 
        $('#id_descricao_meta').attr("disabled", true);
    });
    $("#able_meta").click(function () {
        // habilitando o campo 
        $('#id_descricao_meta').prop("disabled", false);
    });

    $("#disable_indicador").click(function () {
        // desabilitando o campo 
        $('#id_descricao_indicador').attr("disabled", true);
    });
    $("#able_indicador").click(function () {
        // habilitando o campo 
        $('#id_descricao_indicador').prop("disabled", false);
    });

    $("#disable_prazo").click(function () {
        // desabilitando o campo 
        $('#id_descricao_prazo').attr("disabled", true);
    });
    $("#able_prazo").click(function () {
        // habilitando o campo 
        $('#id_descricao_prazo').prop("disabled", false);
    });


    $("#cadastrarPersp").click(function () {
        $.ajax({
            url: "AdicionaPerspectivaServlet",
            type: "POST",
            data: {
                "descricao": $('#id_descricao').val()
            },
            error: function () {
                alert("Não foi possível cadastrar a Perspectiva. Contate o Administrador do sistema.");
            },
            success: function (responseText) {
                alert(responseText);
                $('#form').each(function () {
                    this.reset();
                });
            }
        });
    });
});

function lista() {
    $.ajax({
        url: "ListaPerspectivaServlet",
        type: "POST",
        dataType: "json",
        error: function () {
            alert("Erro de Listagem");
        },
        success: function (responseJson) {
            var teste = document.getElementById('result');
            var itens = "";
            for (var key in responseJson) {
                if (responseJson.hasOwnProperty(key)) {

                    itens += "<tr>";
                    itens += "<td>" + responseJson[key].prsCodigo + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraPerspectiva.jsp?codigo=" + responseJson[key].prsCodigo + "&descricao=" + responseJson[key].descricao + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].prsCodigo + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}
function exclui(codigo) {
    $.ajax({
        url: "ExcluiPerspServlet",
        type: "POST",
        data: {
            "codigo": codigo
        },
        error: function () {
            alert("Não foi possível excluir a Perspectiva. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}
function alterarPersp(codigo, desc) {
    $.ajax({
        url: "AlteraPerspServlet",
        type: "POST",
        data: {
            "codigo": codigo,
            "descricao": desc
        },
        error: function () {
            alert("Não foi possível alterar a Perspectiva. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./perspectiva.jsp";
        }
    });
}

window.onload = lista();
