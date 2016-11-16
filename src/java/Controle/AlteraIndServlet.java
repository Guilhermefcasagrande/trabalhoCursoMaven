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
public class AlteraIndServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ind_sequencia = Integer.parseInt(request.getParameter("indicador"));
        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));
        String descricao = request.getParameter("descricao");
        String situacao = request.getParameter("situacao");

        Indicador ind = new Indicador();
        ind.setIndSequencia(ind_sequencia);
        ind.setObjCodigo(obj_codigo);
        ind.setDescricao(descricao);
        ind.setSituacao(situacao);

        boolean alterou = IndicadorDB.alteraIndicador(ind);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Indicador alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Indicador!");
        }
    }
}
