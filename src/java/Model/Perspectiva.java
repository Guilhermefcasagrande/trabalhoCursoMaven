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
public class Perspectiva {
    
    private int prsCodigo;
    private String descricao;

    public Perspectiva(int prsCodigo, String descricao) {
        this.prsCodigo = prsCodigo;
        this.descricao = descricao;
    }

    public int getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(int prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
