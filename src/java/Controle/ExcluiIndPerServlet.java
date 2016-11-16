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
public class ExcluiIndPerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int indSeq = Integer.parseInt(request.getParameter("indicador"));
        int objCodigo = Integer.parseInt(request.getParameter("objetivo"));
        int perAno = Integer.parseInt(request.getParameter("periodo"));

        IndPer indPer = new IndPer();
        indPer.setIndSequencia(indSeq);
        indPer.setObjCodigo(objCodigo);
        indPer.setPerAno(perAno);

        boolean exclui = IndicadorPerDB.excluiIndPer(indPer);
        if (exclui) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Indicador por Perído excluído com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao excluir o Indicador por Perído!");
        }
    }
}
