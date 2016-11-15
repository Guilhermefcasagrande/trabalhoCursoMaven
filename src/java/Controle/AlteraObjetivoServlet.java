/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Objetivo;
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
public class AlteraObjetivoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));
        int prs_codigo = Integer.parseInt(request.getParameter("perspectiva"));
        String descricao = request.getParameter("descricao");

        Objetivo obj = new Objetivo();
        obj.setObjCodigo(obj_codigo);
        obj.setPrsCodigo(prs_codigo);
        obj.setDescricao(descricao);

        boolean alterou = ObjetivoDB.alteraObjetivo(obj);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Objetivo alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Objetivo!");
        }
    }
}
