/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.IndPer;
import Modelo.Indicador;
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
public class IndicadorPerDB {

    private Connection connection;
    private static String sqlInsere = "insert into ind_per (ind_sequencia,obj_codigo,per_ano,meta,valor,descricao) values (?,?,?,?,?,?);";
    private static String sqlLista = "select * from ind_per order by obj_codigo";

    public IndicadorPerDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(IndPer ind) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getIndSequencia());
            stmt.setInt(2, ind.getObjCodigo());
            stmt.setInt(3, ind.getPerAno());
            stmt.setString(4, ind.getMeta());
            stmt.setString(5, ind.getValor());
            stmt.setString(6, ind.getDescricao());
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
    
    public static ArrayList<IndPer> listaIndPer() {
        ArrayList<IndPer> lista = new ArrayList<IndPer>();
        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int indSequencia = rs.getInt("ind_sequencia");
                int objetivo = rs.getInt("obj_codigo");
                int perAno = rs.getInt("per_ano");
                String meta = rs.getString("meta");
                String valor = rs.getString("valor");
                String descricao = rs.getString("descricao");

                IndPer indPer = new IndPer();
                indPer.setIndSequencia(indSequencia);
                indPer.setObjCodigo(objetivo);
                indPer.setPerAno(perAno);
                indPer.setMeta(meta);
                indPer.setValor(valor);
                indPer.setDescricao(descricao);
                
                lista.add(indPer);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
}
