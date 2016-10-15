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
});

