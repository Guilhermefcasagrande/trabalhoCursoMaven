/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.PlanoAcao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class AlteraPlanoAcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int plano = Integer.parseInt(request.getParameter("plano"));
        int local = Integer.parseInt(request.getParameter("local"));
        String descricao = request.getParameter("descricao");
        String meta = request.getParameter("meta");
        String prazo = request.getParameter("prazo");
        String situacao = request.getParameter("situacao");
        
        PlanoAcao pln = new PlanoAcao();
        pln.setLocCodigo(local);
        pln.setPlnSequencia(plano);
        pln.setDescricao(descricao);
        pln.setMeta(meta);
        pln.setPrazo(prazo);
        pln.setSituacao(situacao);
        
        boolean alterou = PlanoAcaoDB.alteraPlanoAcao(pln);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Plano de Ação alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Plano de Ação!");
        }
    }
}
