/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Guilherme
 */
public class Periodo {

    private int perAno;
    private String descricao;

    public Periodo(int perAno, String descricao) {
        this.perAno = perAno;
        this.descricao = descricao;
    }

    public int getPerAno() {
        return perAno;
    }

    public void setPerAno(int perAno) {
        this.perAno = perAno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
