/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Avi;
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
public class AdicionaAviServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        String instrumento = request.getParameter("instrumento");
        String descricao = request.getParameter("descricao");

        // monta um objeto perspectiva
        Avi avi = new Avi();
        avi.setInstrumento(instrumento);
        avi.setDescricao(descricao);

        // insere a perpectiva
        AviDB ins = new AviDB();
        ins.adiciona(avi);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Avaliação cadastrada com sucesso.");
    }

}
