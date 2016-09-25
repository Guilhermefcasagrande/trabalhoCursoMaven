/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.Dimensoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class DimensoesDB {
    
    private Connection connection;
    
    public DimensoesDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Dimensoes dim) {
        String sql = "insert into dimensoeseixo (descricao) values (?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dim.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
