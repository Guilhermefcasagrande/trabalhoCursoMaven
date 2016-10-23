/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.Avi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class AviDB {
    
    private Connection connection;
    private String sqlInsere = "insert into avi (instrumento,descricao) values (?,?);";
    public AviDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Avi avi) {

        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setString(1, avi.getInstrumento());
            stmt.setString(2, avi.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
