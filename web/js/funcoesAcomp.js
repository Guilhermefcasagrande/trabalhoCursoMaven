/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaMedServlet",
            type: "POST",
            data: {
                "indicador": $('#id_indicador').val(),
                "objetivo": $('#id_objetivo').val(),
                "periodo": $('#id_periodo').val(),
                "local": $('#id_local').val(),
                "plano": $('#id_plano').val(),
                "descricao": $('#id_descricao').val(),
                "valor": $('#id_valor').val()
            },
            error: function () {
                alert("Não foi possível cadastrar o Acompanhemto. Contate o Administrador do sistema.");
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
                    itens += "<a class=\"btn btn-primary\" href=\"alteraPlanoAc.jsp?local=" + responseJson[key].locCodigo + "&descricao=" + responseJson[key].descricao + "&meta=" + responseJson[key].meta +
                            "&prazo=" + responseJson[key].prazo + "&situacao=" + responseJson[key].situacao + "&plano=" + responseJson[key].plnSequencia + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].plnSequencia + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}

function exclui(plano) {
    $.ajax({
        url: "ExcluiPlanAcServlet",
        type: "POST",
        data: {
            "planoAcao": plano
        },
        error: function () {
            alert("Não foi possível excluir o Plano de Ação. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alteraPlanoAc(local, descricao, meta, prazo, situacao, plano) {
    $.ajax({
        url: "AlteraPlanoAcServlet",
        type: "POST",
        data: {
            "local": local,
            "descricao": descricao,
            "meta": meta,
            "prazo": prazo,
            "situacao": situacao,
            "plano": plano
        },
        error: function () {
            alert("Não foi possível alterar o Plano de Ação. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./planoAcaoCoordenador.jsp";
        }
    });
}
window.onload = lista();

