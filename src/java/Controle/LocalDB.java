/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Indicador;
import Modelo.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class LocalDB {

    private Connection connection;
    private static String sqlInsere = "insert into local (descricao,tipo) values (?,?);";
    private static String sqlLista = "select * from local order by loc_codigo";
    private static String sqlExclui = "delete from local where loc_codigo = ?;";
    private static String sqlAltera = "update local set descricao = ?, tipo = ? where loc_codigo = ?";

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
    
    
    public static ArrayList<Local> listaLocal() {
        ArrayList<Local> lista = new ArrayList<Local>();
        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int locCodigo = rs.getInt("loc_codigo");
                String descricao = rs.getString("descricao");
                String tipo = rs.getString("tipo");

                Local local = new Local();
                local.setLocCodigo(locCodigo);
                local.setDescricao(descricao);
                local.setTipo(tipo);
                
                lista.add(local);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
    
    public static boolean excluiLocal(Local local) {
        boolean excluiu = false;

        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, local.getLocCodigo());
            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                excluiu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return excluiu;
        }
    }
    
    public static boolean alteraLocal(Local local) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setString(1, local.getDescricao());
            pstmt.setString(2, local.getTipo());
            pstmt.setInt(3, local.getLocCodigo());

            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                alterou = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQl " + erro.getMessage());
        } finally {
            return alterou;
        }
    }
}
