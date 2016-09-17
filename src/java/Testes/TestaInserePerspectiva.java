/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Control.InserePerspectiva;
import Model.Perspectiva;

/**
 *
 * @author Guilherme
 */
public class TestaInserePerspectiva {
    public static void main(String[] args) {
        Perspectiva persp = new Perspectiva();
        
        persp.setDescricao("TEste");
        
        InserePerspectiva ins = new InserePerspectiva();
        ins.adiciona(persp);
        
        System.out.println("Inserido com sucesso");
    }
}
