/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
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
    private static String sqlInsere = "insert into local (descricao,tipo) values (?,?);";

    public LocalDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(Local loc) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setString(1, loc.getDescricao());
            stmt.setString(2, loc.getTipo());

            int valor = stmt.executeUpdate();
            if (valor == 1) {
                inseriu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        } finally{
            return inseriu;
        }
    }
}
