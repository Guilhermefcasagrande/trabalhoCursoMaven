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
public class Objetivo {

    private int objCodigo;
    private int prsCodigo;
    private String descricao;

    public int getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(int prsCodigo) {
        this.prsCodigo = prsCodigo;
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

}
