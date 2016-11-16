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
public class ExcluiPlanAcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int planoAcao = Integer.parseInt(request.getParameter("planoAcao"));

        PlanoAcao pln = new PlanoAcao();
        pln.setPlnSequencia(planoAcao);

        boolean exclui = PlanoAcaoDB.excluiPlanoAcao(pln);
        if (exclui) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Plano de ação excluído com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao excluir o Plano de ação!");
        }
    }
}
