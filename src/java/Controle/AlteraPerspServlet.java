/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Perspectiva;
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
public class AlteraPerspServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int prs_codigo = Integer.parseInt(request.getParameter("codigo"));
        String descricao = request.getParameter("descricao");

        Perspectiva persp = new Perspectiva();
        persp.setPrsCodigo(prs_codigo);
        persp.setDescricao(descricao);

        boolean alterou = PerspectivaDB.alteraPerspectiva(persp);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Perspectiva alterada com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar a Perspectiva!");
        }
    }

}
