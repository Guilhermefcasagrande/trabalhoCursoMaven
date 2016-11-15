/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.IndPer;
import Modelo.PlanoAcao;
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
public class PlanoAcaoDB {

    private Connection connection;
    private static String sqlInsere = "insert into plano_acao (ind_sequencia,obj_codigo,per_ano,loc_codigo,descricao,meta,prazo,situacao) values (?,?,?,?,?,?,?,?);";
    private static String sqlLista = "select * from plano_acao order by pln_sequencia";

    public PlanoAcaoDB() {
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }

    public static boolean adiciona(PlanoAcao plan) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, plan.getIndSequencia());
            stmt.setInt(2, plan.getObjCodigo());
            stmt.setInt(3, plan.getPerAno());
            stmt.setInt(4, plan.getLocCodigo());
            stmt.setString(5, plan.getDescricao());
            stmt.setString(6, plan.getMeta());
            stmt.setString(7, plan.getPrazo());
            stmt.setString(8, plan.getSituacao());

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

    public static ArrayList<PlanoAcao> listaPlanoAcao() {
        ArrayList<PlanoAcao> lista = new ArrayList<PlanoAcao>();
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
                String meta = rs.getString("meta");
                String prazo = rs.getString("prazo");
                String situacao = rs.getString("situacao");

                PlanoAcao plano = new PlanoAcao();
                
                plano.setPlnSequencia(plnSequencia);
                plano.setLocCodigo(locCodigo);
                plano.setIndSequencia(indSequencia);
                plano.setObjCodigo(objetivo);
                plano.setPerAno(perAno);
                plano.setDescricao(descricao);
                plano.setMeta(meta);
                plano.setPrazo(prazo);
                plano.setSituacao(situacao);

                lista.add(plano);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
}
