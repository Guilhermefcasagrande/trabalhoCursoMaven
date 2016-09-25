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
public class Medicao {

    private int plnSequencia;
    private int locCodigo;
    private int indSequencia;
    private int objCodigo;
    private int perAno;
    private String valor;
    private String descricao;

    public Medicao(int plnSequencia, int locCodigo, int indSequencia, int objCodigo, int perAno, String valor, String descricao) {
        this.plnSequencia = plnSequencia;
        this.locCodigo = locCodigo;
        this.indSequencia = indSequencia;
        this.objCodigo = objCodigo;
        this.perAno = perAno;
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getPlnSequencia() {
        return plnSequencia;
    }

    public void setPlnSequencia(int plnSequencia) {
        this.plnSequencia = plnSequencia;
    }

    public int getLocCodigo() {
        return locCodigo;
    }

    public void setLocCodigo(int locCodigo) {
        this.locCodigo = locCodigo;
    }

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

    public int getPerAno() {
        return perAno;
    }

    public void setPerAno(int perAno) {
        this.perAno = perAno;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
