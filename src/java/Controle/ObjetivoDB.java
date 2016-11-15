/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Objetivo;
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
public class ObjetivoDB {

    private Connection connection;
    private static String sqlInsere = "insert into objetivo (descricao,prs_codigo) values (?,?);";
    private static String sqlExclui = "delete from objetivo where obj_codigo = ?;";
    private static String sqlAltera = "update objetivo set prs_codigo = ?, descricao = ? where obj_codigo = ?";
    private static String sqlLista = "select obj.obj_codigo,\n"
            + "	obj.descricao as objetivo,\n"
            + "	pes.prs_codigo as perspectiva\n"
            + "from objetivo obj\n"
            + "join pespectiva pes on(pes.prs_codigo = obj.prs_codigo)\n"
            + "order by obj_codigo";

    public ObjetivoDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(Objetivo obj) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setString(1, obj.getDescricao());
            stmt.setInt(2, obj.getPrsCodigo());
            int valor = stmt.executeUpdate();
            if (valor == 1) {
                inseriu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        } finally {
            return inseriu;
        }
    }
    
    public static ArrayList<Objetivo> listaObjetivo() {
        ArrayList<Objetivo> lista = new ArrayList<Objetivo>();
        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int codigo = rs.getInt("obj_codigo");
                String descricao = rs.getString("objetivo");
                int descricao2 = rs.getInt("perspectiva");

                Objetivo objetivo = new Objetivo();
                objetivo.setObjCodigo(codigo);
                objetivo.setDescricao(descricao);
                objetivo.setPrsCodigo(descricao2);
                
                lista.add(objetivo);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
    
    public static boolean excluiObjetivo(Objetivo objetivo) {
        boolean excluiu = false;

        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, objetivo.getObjCodigo());
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

    public static boolean alteraObjetivo(Objetivo objetivo) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setInt(1, objetivo.getPrsCodigo());
            pstmt.setString(2, objetivo.getDescricao());
            pstmt.setInt(3, objetivo.getObjCodigo());

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
