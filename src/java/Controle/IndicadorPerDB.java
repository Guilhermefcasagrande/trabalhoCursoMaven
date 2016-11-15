/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
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
    private static String sqlInsere = "insert into ind_per (ind_sequencia,obj_codigo,per_ano,meta,valor,descricao) values (?,?,?,?,?,?);";

    public IndicadorPerDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(IndPer ind) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getIndSequencia());
            stmt.setInt(2, ind.getObjCodigo());
            stmt.setInt(3, ind.getPerAno());
            stmt.setString(4, ind.getMeta());
            stmt.setString(5, ind.getValor());
            stmt.setString(6, ind.getDescricao());
            int valor = stmt.executeUpdate();
            if (valor == 1) {
                inseriu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        } finally {
            return inseriu;
        }
    }
}
