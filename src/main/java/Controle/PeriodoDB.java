/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Modelo.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class PeriodoDB {

    private Connection connection;

    public PeriodoDB() {
        this.connection = new ConexaoElephant().getConnection();
    }

    public void adiciona(Periodo per) {
        String sql = "insert into periodo (descricao) values (?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, per.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
