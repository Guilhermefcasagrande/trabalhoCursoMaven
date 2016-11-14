/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Perspectiva;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Guilherme
 */
public class ListaPerspectivaServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PerspectivaDB pdb = new PerspectivaDB();
        ArrayList<Perspectiva> teste = pdb.listaPerspectiva();
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i == teste.size(); i++){
            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("nome",teste.get(i).getDescricao());
                jsonObj.put("id",teste.get(i).getPrsCodigo());
                
                jsonArray.put(jsonObj);
            } catch (JSONException ex) {
                System.out.println("Erro de json: " + ex.getMessage());
            }
        }
        out.print(jsonArray);
    }
}
