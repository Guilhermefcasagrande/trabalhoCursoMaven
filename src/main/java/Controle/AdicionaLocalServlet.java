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
        // busca o writer
        PrintWriter out = response.getWriter();

        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");

        // monta um objeto perspectiva
        Local loc = new Local();
        loc.setDescricao(descricao);
        loc.setTipo(tipo);

        // insere a perpectiva
        LocalDB ins = new LocalDB();
        ins.adiciona(loc);

        System.out.println("Inserido");

    }

}
