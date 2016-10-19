/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class ConexaoPostgres {

    private static String url = "jdbc:postgresql://localhost:5432/PEI";
    private static String usuario = "postgres";
    private static String senha = "1";

    public Connection getConnection() {

        try {
            System.out.println("Conexão estabelecida com Sucesso");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println("Falha de Conxão");
            throw new RuntimeException(ex);
        }
    }
}
