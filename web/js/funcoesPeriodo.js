/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#cadastrar").click(function () {
        $.ajax({
            url: "AdicionaPeriodoServlet",
            type: "POST",
            data: {
                "descricao": $('#id_descricao').val()
            },
            error: function () {
                alert("Não foi possível cadastrar o Período. Contate o Administrador do sistema.");
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
        url: "ListaPeriodoServlet",
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
                    itens += "<td>" + responseJson[key].perAno + "</td>";
                    itens += "<td>" + responseJson[key].descricao + "</td>";
                    itens += "<td>";
                    itens += "<div class=\"btn-group\">";
                    itens += "<a class=\"btn btn-primary\" href=\"alteraPeriodo.jsp?perAno=" + responseJson[key].perAno + "&descricao=" + responseJson[key].descricao + "\" ><i class=\"icon_plus_alt2\"></i></a>";
                    itens += "<a class=\"btn btn-danger\" href=\"#\" onclick=\"exclui(" + responseJson[key].perAno + ");\"><i class=\"icon_close_alt2\"></i></a>";
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
        url: "ExcluiPerServlet",
        type: "POST",
        data: {
            "perAno": codigo
        },
        error: function () {
            alert("Não foi possível excluir o Período. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            lista();
        }
    });
}

function alterarPeriodo(perAno, desc) {
    $.ajax({
        url: "AlteraPerServlet",
        type: "POST",
        data: {
            "perAno": perAno,
            "descricao": desc
        },
        error: function () {
            alert("Não foi possível alterar o Período. Contate o Administrador do sistema.");
        },
        success: function (responseText) {
            alert(responseText);
            window.location.href = "./periodo.jsp";
        }
    });
}
window.onload = lista();
