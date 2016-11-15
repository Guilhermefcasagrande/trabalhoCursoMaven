/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaPlanoAcaoServlet",
            type: "POST",
            data: {
                "indicador": $('#id_indicador').val(),
                "objetivo": $('#id_objetivo').val(),
                "periodo": $('#id_periodo').val(),
                "local": $('#id_local').val(),
                "meta": $('#id_meta').val(),
                "prazo": $('#id_prazo').val(),
                "situacao": $('#id_situacao').val(),
                "descricao": $('#id_descricao').val()
            },
            error: function () {
                alert("Não foi possível cadastrar o Plano de Ação. Contate o Administrador do sistema.");
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
        url: "ListaPlnAcaoServlet",
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
                    itens += "<td>" + responseJson[key].plnSequencia + "</td>";
                    itens += "<td>" + responseJson[key].locCodigo + "</td>";
                    itens += "<td>" + responseJson[key].indSequencia + "</td>";
                    itens += "<td>" + responseJson[key].objCodigo + "</td>";
                    itens += "<td>" + responseJson[key].perAno + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>" + responseJson[key].meta + "</td>";
                    itens += "<td>" + responseJson[key].prazo + "</td>";
                    itens += "<td>" + responseJson[key].situacao + "</td>";
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
