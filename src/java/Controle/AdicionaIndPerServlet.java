/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.IndPer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class AdicionaIndPerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando os parâmetros no request
        int ind_sequencia = Integer.parseInt(request.getParameter("indicador"));
        int obj_codigo = Integer.parseInt(request.getParameter("objetivo"));
        int per_ano = Integer.parseInt(request.getParameter("periodo"));
        String meta = request.getParameter("meta");
        String valor = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

        // monta um objeto indicador
        IndPer indper = new IndPer();
        indper.setIndSequencia(ind_sequencia);
        indper.setObjCodigo(obj_codigo);
        indper.setPerAno(per_ano);
        indper.setMeta(meta);
        indper.setValor(valor);
        indper.setDescricao(descricao);

        // insere o indicador
        boolean inseriu = IndicadorPerDB.adiciona(indper);

        if (inseriu) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Indicador cadastrado com sucesso!");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Erro ao cadastrar o indicador");
        }
    }
}
