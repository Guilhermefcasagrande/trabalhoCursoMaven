/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Local;
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
public class AdicionaLocalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");

        // monta um objeto perspectiva
        Local loc = new Local();
        loc.setDescricao(descricao);
        loc.setTipo(tipo);

        // insere a perpectiva
        boolean inseriu = LocalDB.adiciona(loc);
        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Local cadastrado com sucesso.");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao Cadastrar o local");
        }
    }
}
