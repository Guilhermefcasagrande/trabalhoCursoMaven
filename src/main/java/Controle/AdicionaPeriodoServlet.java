/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Periodo;
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
public class AdicionaPeriodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // busca o writer
        PrintWriter out = response.getWriter();

        // buscando os parâmetros no request
        String descricao = request.getParameter("descricao");

        // monta um objeto perspectiva
        Periodo per = new Periodo();
        per.setDescricao(descricao);
        
        // insere a perpectiva
        PeriodoDB ins = new PeriodoDB();
        ins.adiciona(per);

        System.out.println("Inserido");
    }

}
