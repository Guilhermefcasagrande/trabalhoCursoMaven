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
    private String sqlInsere = "insert into dimensoeseixo (descricao) values (?);";
    
    public DimensoesDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Dimensoes dim) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setString(1, dim.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
