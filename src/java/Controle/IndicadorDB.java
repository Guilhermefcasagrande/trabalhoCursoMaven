/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Indicador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class IndicadorDB {
    private Connection connection;
    private static String sqlInsere = "insert into indicadores (obj_codigo,descricao,situacao) values (?,?,?);";
    
    public IndicadorDB(){
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }
    
    public static boolean adiciona(Indicador ind) {
        boolean inseriu = false;
        try {
            
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getObjCodigo());
            stmt.setString(2, ind.getDescricao());
            stmt.setString(3, ind.getSituacao());
            int valor = stmt.executeUpdate();
            if(valor == 1){
                inseriu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally{
            return inseriu;
        }
    }
}
