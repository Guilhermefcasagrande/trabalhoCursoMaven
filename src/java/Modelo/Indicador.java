/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Guilherme
 */
public class Indicador {
    private int indSequencia;
    private int objCodigo;
    private String descricao;
    private String situacao;

    public int getIndSequencia() {
        return indSequencia;
    }

    public void setIndSequencia(int indSequencia) {
        this.indSequencia = indSequencia;
    }

    public int getObjCodigo() {
        return objCodigo;
    }

    public void setObjCodigo(int objCodigo) {
        this.objCodigo = objCodigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
