/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaObjetivoServlet",
            type: "POST",
            data: {
                "descricao": $('#id_descricao').val(),
                "prs_codigo": $('#id_perspectiva').val()
            },
            error: function () {
                alert("Não foi possível cadastrar o Objetivo. Contate o Administrador do sistema.");
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
        url: "ListaObjetivoServlet",
        type: "POST",
        dataType: "json",
        error: function () {
            alert("Erro de Listagem");
        },
        success: function (responseJson) {
            var itens = "";
            for (var key in responseJson) {
                if (responseJson.hasOwnProperty(key)) {

                    itens += "<tr>";
                    itens += "<td>" + responseJson[key].objCodigo + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>" + responseJson[key].prsCodigo + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraObjetivo.jsp?objetivo=" + responseJson[key].objCodigo + "&descricao=" + responseJson[key].descricao + "&perspectiva=" + responseJson[key].prsCodigo + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].objCodigo + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}
window.onload = lista();

function exclui(objetivo) {
    $.ajax({
        url: "ExcluiObjServlet",
        type: "POST",
        data: {
            "objetivo": objetivo
        },
        error: function () {
            alert("Não foi possível excluir o Objetivo. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alteraObj(objetivo, descricao, perspectiva) {
    $.ajax({
        url: "AlteraObjetivoServlet",
        type: "POST",
        data: {
            "objetivo": objetivo,
            "descricao": descricao,
            "perspectiva": perspectiva
        },
        error: function () {
            alert("Não foi possível alterar o Objetivo. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./objetivo.jsp";
        }
    });
}

