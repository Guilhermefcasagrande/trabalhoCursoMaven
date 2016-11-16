/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaLocalServlet",
            type: "POST",
            data: {
                "descricao": $('#id_descricao').val(),
                "tipo": $('#id_tipo').val()
            },
            error: function () {
                alert("Não foi possível cadastrar o Local. Contate o Administrador do sistema.");
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
        url: "ListaLocalServlet",
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
                    itens += "<td>" + responseJson[key].locCodigo + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>" + responseJson[key].tipo + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraLocal.jsp?codigo=" + responseJson[key].locCodigo + "&descricao=" + responseJson[key].descricao + "&tipo=" + responseJson[key].tipo + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].locCodigo + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}

function exclui(local) {
    $.ajax({
        url: "ExcluiLocServlet",
        type: "POST",
        data: {
            "locCodigo": local
        },
        error: function () {
            alert("Não foi possível excluir o Local. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alteraLoc(locCodigo, descricao, tipo) {
    $.ajax({
        url: "AlteraLocServlet",
        type: "POST",
        data: {
            "locCodigo": locCodigo,
            "descricao": descricao,
            "tipo": tipo
        },
        error: function () {
            alert("Não foi possível alterar o Objetivo. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./local.jsp";
        }
    });
}
window.onload = lista();
