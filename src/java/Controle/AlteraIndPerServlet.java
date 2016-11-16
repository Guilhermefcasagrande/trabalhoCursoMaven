/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.IndPer;
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
public class AlteraIndPerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int indicador = Integer.parseInt(request.getParameter("indicador"));
        int objetivo = Integer.parseInt(request.getParameter("objetivo"));
        int periodo = Integer.parseInt(request.getParameter("periodo"));
        String meta = request.getParameter("meta");
        String valor = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

        IndPer indPer = new IndPer();
        indPer.setIndSequencia(indicador);
        indPer.setObjCodigo(objetivo);
        indPer.setPerAno(periodo);
        indPer.setMeta(meta);
        indPer.setValor(valor);
        indPer.setDescricao(descricao);

        boolean alterou = IndicadorPerDB.alteraIndPer(indPer);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Indicador por Período alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Indicador por Período!");
        }
    }
}
