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
        url: "ListaMedServlet",
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
                    itens += "<td>" + responseJson[key].valor + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraMedicao.jsp?plano=" + responseJson[key].plnSequencia + "&local=" + responseJson[key].locCodigo + "&indicador=" + responseJson[key].indSequencia +
                            "&objetivo=" + responseJson[key].objCodigo + "&periodo=" + responseJson[key].perAno + "&valor=" + responseJson[key].valor + "&descricao="+responseJson[key].descricao+"\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].plnSequencia + "," + responseJson[key].locCodigo + "," + responseJson[key].indSequencia +
                            "," + responseJson[key].objCodigo + "," + responseJson[key].perAno + ");\"><i class=\"icon_close_alt2\"></i></a>";
                    itens += "</div>";
                    itens += "</td>";
                    itens += "</tr>";

                }
            }
            $("#result").html(itens);
        }
    });
}

function exclui(plano, local, indicador, objetivo, periodo) {
    $.ajax({
        url: "ExcluiMedServlet",
        type: "POST",
        data: {
            "planoAcao": plano,
            "local": local,
            "indicador": indicador,
            "objetivo": objetivo,
            "periodo": periodo
        },
        error: function () {
            alert("Não foi possível excluir o Acompanhamento. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alteraAcomp(plano, local, indicador, objetivo, periodo, valor, descricao) {
    $.ajax({
        url: "AlteraMedServlet",
        type: "POST",
        data: {
            "plano": plano,
            "local": local,
            "indicador": indicador,
            "objetivo": objetivo,
            "periodo": periodo,
            "valor": valor,
            "descricao": descricao
        },
        error: function () {
            alert("Não foi possível alterar o Plano de Ação. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./medicoes.jsp";
        }
    });
}
window.onload = lista();

