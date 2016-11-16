/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.Medicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class MedicoesDB {
    private Connection connection;
    private static String sqlInsere = "insert into medicao (ind_sequencia,obj_codigo,per_ano,loc_codigo,descricao,valor,pln_sequencia) values (?,?,?,?,?,?,?);";
    private static String sqlLista = "select * from plano_acao order by pln_sequencia";
    private static String sqlExclui = "delete from plano_acao where pln_sequencia = ?;";
    private static String sqlAltera = "update plano_acao set loc_codigo = ?,descricao = ?, meta = ?, prazo = ?, situacao = ? where pln_sequencia = ?";
    
    public MedicoesDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }
    
    public static boolean adiciona(Medicao med) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, med.getIndSequencia());
            stmt.setInt(2, med.getObjCodigo());
            stmt.setInt(3, med.getPerAno());
            stmt.setInt(4, med.getLocCodigo());
            stmt.setString(5, med.getDescricao());
            stmt.setString(6, med.getValor());
            stmt.setInt(7, med.getPlnSequencia());

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
