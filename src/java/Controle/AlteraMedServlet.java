/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Medicao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class AlteraMedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int local = Integer.parseInt(request.getParameter("local"));
        int indicador = Integer.parseInt(request.getParameter("indicador"));
        int objetivo = Integer.parseInt(request.getParameter("objetivo"));
        int plano = Integer.parseInt(request.getParameter("plano"));
        int periodo = Integer.parseInt(request.getParameter("periodo"));
        String valor = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

        Medicao med = new Medicao();
        med.setPlnSequencia(plano);
        med.setLocCodigo(local);
        med.setIndSequencia(indicador);
        med.setObjCodigo(objetivo);
        med.setPerAno(periodo);
        med.setValor(valor);
        med.setDescricao(descricao);

        boolean alterou = MedicoesDB.alteraMedicao(med);
        if (alterou) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Acompanhamento alterado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao alterar o Acompanhamento!");
        }
    }
}
