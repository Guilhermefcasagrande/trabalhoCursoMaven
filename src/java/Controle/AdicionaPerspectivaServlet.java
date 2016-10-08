/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Perspectiva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaPerspectivaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");

        // monta um objeto perspectiva
        Perspectiva perspectiva = new Perspectiva();
        perspectiva.setDescricao(descricao);

        // insere a perspectiva
        PerspectivaDB ins = new PerspectivaDB();
        ins.adiciona(perspectiva);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Perspectiva cadastrada com sucesso");

        //RequestDispatcher red = request.getRequestDispatcher("perspectiva.jsp");
        //red.forward(request, response);
    }
}
