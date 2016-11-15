/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.PlanoAcao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaPlanoAcaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        int ind_sequencia = Integer.parseInt(request.getParameter("indicador"));
        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));
        int per_ano = Integer.parseInt(request.getParameter("periodo"));
        int loc_codigo = Integer.parseInt(request.getParameter("local"));
        String meta = request.getParameter("meta");
        String prazo = request.getParameter("prazo");
        String descricao = request.getParameter("descricao");
        String situacao = request.getParameter("situacao");

        // monta um objeto indicador
        PlanoAcao plan = new PlanoAcao();
        plan.setIndSequencia(ind_sequencia);
        plan.setObjCodigo(obj_codigo);
        plan.setPerAno(per_ano);
        plan.setLocCodigo(loc_codigo);
        plan.setDescricao(descricao);
        plan.setMeta(meta);
        plan.setPrazo(prazo);
        plan.setSituacao(situacao);

        // insere o indicador
        boolean inseriu = PlanoAcaoDB.adiciona(plan);
        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Plano de Ação cadastrado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao cadastrar o plano de ação");
        }
    }
}
