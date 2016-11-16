/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaIndicadorServlet",
            type: "POST",
            data: {
                "descricao": $('#id_descricao').val(),
                "situacao": $('#id_situação').val(),
                "objetivo": $('#id_objetivo').val()
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
        url: "ListaIndicadorServlet",
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
                    itens += "<td>" + responseJson[key].indSequencia + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>" + responseJson[key].objCodigo + "</td>";
                    itens += "<td>" + responseJson[key].situacao + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraIndicador.jsp?objetivo=" + responseJson[key].objCodigo + "&descricao=" + responseJson[key].descricao + "&indicador=" + responseJson[key].indSequencia + "&situacao=" + responseJson[key].situacao + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].indSequencia + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}

function exclui(indicador) {
    $.ajax({
        url: "ExcluiIndServlet",
        type: "POST",
        data: {
            "indicador": indicador
        },
        error: function () {
            alert("Não foi possível excluir o Indicador. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alteraInd(indicador, descricao, situacao, objetivo) {
    $.ajax({
        url: "AlteraIndServlet",
        type: "POST",
        data: {
            "objetivo": objetivo,
            "descricao": descricao,
            "situacao": situacao,
            "indicador": indicador
        },
        error: function () {
            alert("Não foi possível alterar o Indicador. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./indicador.jsp";
        }
    });
}
window.onload = lista();