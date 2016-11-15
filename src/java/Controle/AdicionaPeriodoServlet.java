/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Periodo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaPeriodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");

        // monta um objeto perspectiva
        Periodo periodo = new Periodo();
        periodo.setDescricao(descricao);

        // insere a perspectiva
        boolean inseriu = PeriodoDB.adiciona(periodo);
        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Periodo cadastrado com sucesso");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao cadastrar o periodo");
        }

    }

}
