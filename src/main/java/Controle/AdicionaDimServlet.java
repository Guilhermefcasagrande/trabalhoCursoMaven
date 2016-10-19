/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Dimensoes;
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
public class AdicionaDimServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");

        // monta um objeto perspectiva
        Dimensoes dim = new Dimensoes();
        dim.setDescricao(descricao);

        // insere a perspectiva
        DimensoesDB ins = new DimensoesDB();
        ins.adiciona(dim);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Dimensão cadastrada com sucesso!");
    }

}
