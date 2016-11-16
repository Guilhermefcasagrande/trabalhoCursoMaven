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
public class ExcluiMedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int plano = Integer.parseInt(request.getParameter("planoAcao"));
        int local = Integer.parseInt(request.getParameter("local"));
        int indSeq = Integer.parseInt(request.getParameter("indicador"));
        int objCodigo = Integer.parseInt(request.getParameter("objetivo"));
        int perAno = Integer.parseInt(request.getParameter("periodo"));

        Medicao med = new Medicao();
        med.setIndSequencia(indSeq);
        med.setLocCodigo(local);
        med.setObjCodigo(objCodigo);
        med.setPlnSequencia(plano);
        med.setPerAno(perAno);

        boolean exclui = MedicoesDB.excluiMedicao(med);
        if (exclui) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Acompanhamento excluído com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao excluir o Acompanhamento!");
        }
    }
}
