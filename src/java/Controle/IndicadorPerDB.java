/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.IndPer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class IndicadorPerDB {
    private Connection connection;
    private String sqlInsere = "insert into ind_per (ind_sequencia,obj_codigo,per_ano,meta,valor,descricao) values (?,?,?,?,?,?);";
    
    public IndicadorPerDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(IndPer ind) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getIndSequencia());
            stmt.setInt(2, ind.getObjCodigo());
            stmt.setInt(3, ind.getPerAno());
            stmt.setString(4, ind.getMeta());
            stmt.setString(5, ind.getValor());
            stmt.setString(6, ind.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
