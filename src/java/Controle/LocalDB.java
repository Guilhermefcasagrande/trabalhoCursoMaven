/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class LocalDB {

    private Connection connection;

    public LocalDB() {
        this.connection = new ConexaoElephant().getConnection();
    }

    public void adiciona(Local loc) {
        String sql = "insert into local (descricao,tipo) values (?,?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, loc.getDescricao());
            stmt.setString(2, loc.getTipo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
