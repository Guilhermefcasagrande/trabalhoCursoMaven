/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Objetivo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaObjetivoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");
        int prs_codigo = Integer.parseInt(request.getParameter("prs_codigo"));

        // monta um objeto objetivo
        Objetivo objetivo = new Objetivo();
        objetivo.setDescricao(descricao);
        objetivo.setPrsCodigo(prs_codigo);

        // insere o objetivo
        ObjetivoDB ins = new ObjetivoDB();
        ins.adiciona(objetivo);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Objetivo cadastrado com sucesso!");
    }

}
