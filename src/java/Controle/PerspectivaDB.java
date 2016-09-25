/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Perspectiva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class PerspectivaDB {
    private Connection connection;
    
    public PerspectivaDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Perspectiva persp){
        String sql = "insert into pespectiva (descricao) values (?);";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, persp.getDescricao());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
