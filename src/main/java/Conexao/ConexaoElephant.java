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
public class ConexaoElephant {

    private static String driver = "org.postgresql.Driver";
    private static String servidor = "elmer-01.db.elephantsql.com";
    private static String banco = "ixwnihms";
    private static String usuario = "ixwnihms";
    private static String senha = "w3X_1R9ZYhAgKj7KF8-1hCZTrwWX6A_F";
    private static String url = "jdbc:postgresql://" + servidor + ":5432/" + banco;

    public static Connection getConnection() {
        Connection conexao = null;

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com sucesso");

        } catch (ClassNotFoundException erro) {
            System.out.println("Erro de driver " + erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return conexao;
        }

    }

    public static void fechaConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException erro) {
                System.out.println("Erro ao fechar Conexao");
            }
        }

    }
}
