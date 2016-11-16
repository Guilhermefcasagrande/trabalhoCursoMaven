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
public class AlteraLocServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int locCodigo = Integer.parseInt(request.getParameter("locCodigo"));
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");

        Local loc = new Local();
        loc.setLocCodigo(locCodigo);
        loc.setDescricao(descricao);
        loc.setTipo(tipo);

        boolean alterou = LocalDB.alteraLocal(loc);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Local alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Local!");
        }
    }
}
