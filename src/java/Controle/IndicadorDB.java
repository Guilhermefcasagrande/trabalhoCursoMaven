/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
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
    private String sqlInsere = "insert into indicadores (obj_codigo,descricao,situacao) values (?,?,?);";
    
    public IndicadorDB(){
        this.connection = new ConexaoElephant().getConnection();
    }
    
    public void adiciona(Indicador ind) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getObjCodigo());
            stmt.setString(2, ind.getDescricao());
            stmt.setString(3, ind.getSituacao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
