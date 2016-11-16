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
public class AdicionaMedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        int ind_sequencia = Integer.parseInt(request.getParameter("indicador"));
        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));
        int per_ano = Integer.parseInt(request.getParameter("periodo"));
        int loc_codigo = Integer.parseInt(request.getParameter("local"));
        int pln_codigo = Integer.parseInt(request.getParameter("plano"));
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        Medicao med = new Medicao();
        med.setIndSequencia(ind_sequencia);
        med.setObjCodigo(obj_codigo);
        med.setPerAno(per_ano);
        med.setLocCodigo(loc_codigo);
        med.setPlnSequencia(pln_codigo);
        med.setDescricao(descricao);
        med.setValor(valor);

        boolean inseriu = MedicoesDB.adiciona(med);
        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Acompanhamento cadastrado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao cadastrar o acompanhamento");
        }
    }
}
