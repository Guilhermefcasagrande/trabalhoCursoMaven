/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Indicador;
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
public class IndicadorDB {
    private Connection connection;
    private static String sqlInsere = "insert into indicadores (obj_codigo,descricao,situacao) values (?,?,?);";
    private static String sqlLista = "select * from indicadores order by ind_sequencia";
    
    public IndicadorDB(){
        //this.connection = new ConexaoElephant().getConnection();
        this.connection = new ConexaoPostgres().getConnection();
    }
    
    public static boolean adiciona(Indicador ind) {
        boolean inseriu = false;
        try {
            
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
            stmt.setInt(1, ind.getObjCodigo());
            stmt.setString(2, ind.getDescricao());
            stmt.setString(3, ind.getSituacao());
            int valor = stmt.executeUpdate();
            if(valor == 1){
                inseriu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally{
            return inseriu;
        }
    }
    
    public static ArrayList<Indicador> listaIndicador() {
        ArrayList<Indicador> lista = new ArrayList<Indicador>();
        try {
            //Connection conexao = ConexaoElephant.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int indSequencia = rs.getInt("ind_sequencia");
                int objetivo = rs.getInt("obj_codigo");
                String descricao = rs.getString("descricao");
                String situacao = rs.getString("situacao");

                Indicador indicador = new Indicador();
                indicador.setIndSequencia(indSequencia);
                indicador.setObjCodigo(objetivo);
                indicador.setDescricao(descricao);
                indicador.setSituacao(situacao);
                lista.add(indicador);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
}
