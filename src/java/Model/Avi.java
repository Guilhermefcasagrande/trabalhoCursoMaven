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
public class Avi {

    private int aviCodigo;
    private String instrumento;
    private String descricao;

    public Avi(int aviCodigo, String instrumento, String descricao) {
        this.aviCodigo = aviCodigo;
        this.instrumento = instrumento;
        this.descricao = descricao;
    }

    
    public int getAviCodigo() {
        return aviCodigo;
    }

    public void setAviCodigo(int aviCodigo) {
        this.aviCodigo = aviCodigo;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
