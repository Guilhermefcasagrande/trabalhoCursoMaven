/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Controle.PerspectivaDB;
import Modelo.Perspectiva;

/**
 *
 * @author Guilherme
 */
public class TestaInserePerspectiva {
    public static void main(String[] args) {
        Perspectiva persp = new Perspectiva();
        
        persp.setDescricao("TEste");
        
        PerspectivaDB ins = new PerspectivaDB();
        ins.adiciona(persp);
        
        System.out.println("Inserido com sucesso");
    }
}
