/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Model.Perspectiva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class InserePerspectiva {
    private Connection connection;
    
    public InserePerspectiva(){
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
