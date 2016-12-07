/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
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
});

function lista() {
    $.ajax({
        url: "ListaIndPerServlet",
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
                    itens += "<td>" + responseJson[key].objCodigo + "</td>";
                    itens += "<td>" + responseJson[key].perAno + "</td>";
                    itens += "<td>" + responseJson[key].meta + "</td>";
                    itens += "<td>" + responseJson[key].valor + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraIndPer.jsp?indicador=" + responseJson[key].indSequencia + "&objetivo=" + responseJson[key].objCodigo + "&periodo="
                            + responseJson[key].perAno + "&meta=" + responseJson[key].meta + "&valor=" + responseJson[key].valor + "&descricao=" + responseJson[key].descricao + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].indSequencia + "," + responseJson[key].objCodigo + "," + responseJson[key].perAno + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}

function exclui(indicador, objetivo, periodo) {
    $.ajax({
        url: "ExcluiIndPerServlet",
        type: "POST",
        data: {
            "indicador": indicador,
            "objetivo": objetivo,
            "periodo": periodo
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

function alteraIndPer(indicador, objetivo, periodo, meta, valor, descricao) {
    $.ajax({
        url: "AlteraIndPerServlet",
        type: "POST",
        data: {
            "objetivo": objetivo,
            "descricao": descricao,
            "periodo": periodo,
            "meta": meta,
            "valor": valor,
            "indicador": indicador
        },
        error: function () {
            alert("Não foi possível alterar o Indicador. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./indicadorPeriodo.jsp";
        }
    });
}
window.onload = lista();

