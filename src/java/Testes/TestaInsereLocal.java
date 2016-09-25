/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Controle.LocalDB;
import Modelo.Local;

/**
 *
 * @author Guilherme
 */
public class TestaInsereLocal {
    public static void main(String[] args) {
        Local loc = new Local();
        
        loc.setDescricao("Teste");
        loc.setTipo("TEESTE");
        
        LocalDB ins = new LocalDB();
        ins.adiciona(loc);
        
        System.out.println("Inserido com sucesso");
    }
}
