/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.IndPer;
import Modelo.PlanoAcao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class PlanoAcaoDB {

    private Connection connection;
    private String sqlInsere = "insert into plano_acao (ind_sequencia,obj_codigo,per_ano,loc_codigo,descricao,meta,prazo,situacao) values (?,?,?,?,?,?,?,?);";
    
    public PlanoAcaoDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(PlanoAcao plan) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setInt(1, plan.getIndSequencia());
            stmt.setInt(2, plan.getObjCodigo());
            stmt.setInt(3, plan.getPerAno());
            stmt.setInt(4, plan.getLocCodigo());
            stmt.setString(5, plan.getDescricao());
            stmt.setString(6, plan.getMeta());
            stmt.setString(7, plan.getPrazo());
            stmt.setString(8, plan.getSituacao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
