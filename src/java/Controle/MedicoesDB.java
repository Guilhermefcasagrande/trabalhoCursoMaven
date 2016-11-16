/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.Medicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MedicoesDB {

    private Connection connection;
    private static String sqlInsere = "insert into medicao (ind_sequencia,obj_codigo,per_ano,loc_codigo,descricao,valor,pln_sequencia) values (?,?,?,?,?,?,?);";
    private static String sqlLista = "select * from medicao order by pln_sequencia";
    private static String sqlExclui = "delete from medicao where pln_sequencia = ? and loc_codigo = ? and ind_sequencia = ? and obj_codigo = ? and per_ano = ?;";
    private static String sqlAltera = "update medicao set valor = ?,descricao = ? where pln_sequencia = ? and loc_codigo = ? and ind_sequencia = ? and obj_codigo = ? and per_ano = ?";

    public MedicoesDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(Medicao med) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, med.getIndSequencia());
            stmt.setInt(2, med.getObjCodigo());
            stmt.setInt(3, med.getPerAno());
            stmt.setInt(4, med.getLocCodigo());
            stmt.setString(5, med.getDescricao());
            stmt.setString(6, med.getValor());
            stmt.setInt(7, med.getPlnSequencia());

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

    public static ArrayList<Medicao> listaMedicao() {
        ArrayList<Medicao> lista = new ArrayList<Medicao>();
        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int plnSequencia = rs.getInt("pln_sequencia");
                int locCodigo = rs.getInt("loc_codigo");
                int indSequencia = rs.getInt("ind_sequencia");
                int objetivo = rs.getInt("obj_codigo");
                int perAno = rs.getInt("per_ano");
                String descricao = rs.getString("descricao");
                String valor = rs.getString("valor");

                Medicao med = new Medicao();

                med.setPlnSequencia(plnSequencia);
                med.setLocCodigo(locCodigo);
                med.setIndSequencia(indSequencia);
                med.setObjCodigo(objetivo);
                med.setPerAno(perAno);
                med.setDescricao(descricao);
                med.setValor(valor);

                lista.add(med);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public static boolean excluiMedicao(Medicao med) {
        boolean excluiu = false;

        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, med.getPlnSequencia());
            pstmt.setInt(2, med.getLocCodigo());
            pstmt.setInt(3, med.getIndSequencia());
            pstmt.setInt(4, med.getObjCodigo());
            pstmt.setInt(5, med.getPerAno());

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

    public static boolean alteraMedicao(Medicao med) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);
            pstmt.setString(1, med.getValor()); 
            pstmt.setString(2, med.getDescricao()); 
            pstmt.setInt(3, med.getPlnSequencia());
            pstmt.setInt(4, med.getLocCodigo());
            pstmt.setInt(5, med.getIndSequencia());
            pstmt.setInt(6, med.getObjCodigo());
            pstmt.setInt(7, med.getPerAno());

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
