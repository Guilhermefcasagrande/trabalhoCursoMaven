/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.Objetivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class ObjetivoDB {
     private Connection connection;
    private String sqlInsere = "insert into objetivo (descricao,prs_codigo) values (?,?);";
    
    public ObjetivoDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Objetivo obj){
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setString(1, obj.getDescricao());
            stmt.setInt(2, obj.getPrsCodigo());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
