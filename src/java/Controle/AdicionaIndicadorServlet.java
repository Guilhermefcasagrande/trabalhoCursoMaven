/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Indicador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaIndicadorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");
        String situacao = request.getParameter("situacao");
        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));

        // monta um objeto indicador
        Indicador indicador = new Indicador();
        indicador.setDescricao(descricao);
        indicador.setSituacao(situacao);
        indicador.setObjCodigo(obj_codigo);

        // insere o indicador
        boolean inseriu = IndicadorDB.adiciona(indicador);

        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Indicador cadastrado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao cadastrar o indicador");
        }

    }
}
