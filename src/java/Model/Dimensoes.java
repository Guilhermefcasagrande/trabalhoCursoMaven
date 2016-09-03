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
public class Dimensoes {
    
    private int dimCodigo;
    private String descricao;

    public int getDimCodigo() {
        return dimCodigo;
    }

    public void setDimCodigo(int dimCodigo) {
        this.dimCodigo = dimCodigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Dimensoes(int dimCodigo, String descricao) {
        this.dimCodigo = dimCodigo;
        this.descricao = descricao;
    }
 
}
