/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElephant;
import Conexao.ConexaoPostgres;
import Modelo.Perspectiva;
import static java.lang.System.out;
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
public class PerspectivaDB {

    private Connection connection;
    private static String sqlLista = "select * from pespectiva";
    private static String sqlInsere = "insert into pespectiva (descricao) values (?);";

    public PerspectivaDB() {
        this.connection = new ConexaoElephant().getConnection();
    }

    public void adiciona(Perspectiva persp) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlInsere);
            stmt.setString(1, persp.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }

    public static ArrayList<Perspectiva> listaPerspectiva() {
        ArrayList<Perspectiva> lista = new ArrayList<Perspectiva>();
        try {
            Connection conexao = ConexaoElephant.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);

            while (rs.next()) {
                int codigo = rs.getInt("prs_codigo");
                String descricao = rs.getString("descricao");
                
                Perspectiva persp = new Perspectiva();
                persp.setDescricao(descricao);
                persp.setPrsCodigo(codigo);
                
                lista.add(persp);
            }
            ConexaoElephant.fechaConexao(conexao);
            System.out.println(lista);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        } finally {
            return lista;
        }
    }
}
