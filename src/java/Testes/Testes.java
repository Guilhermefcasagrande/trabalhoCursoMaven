/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Conexao.ConexaoPostgres;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class Testes {
    public static void main(String[] args) throws SQLException {
        
        Connection con = new ConexaoPostgres().getConnection();
        con.close();
    }
}
