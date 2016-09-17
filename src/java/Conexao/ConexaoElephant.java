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

    private static String url = "jdbc:postgresql://elmer-01.db.elephantsql.com:5432/ixwnihms";
    private static String usuario = "ixwnihms";
    private static String senha = "w3X_1R9ZYhAgKj7KF8-1hCZTrwWX6A_F";

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
