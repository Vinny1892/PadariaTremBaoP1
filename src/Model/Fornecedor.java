/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Enoque
 */
public class Fornecedor extends Pessoa {
    private float taxa;
    private boolean recorrente;
    private String cnpj;

    public Fornecedor(float taxa, boolean recorrente, String cnpj, String nome, String endereco) {
        super(nome, endereco);
        this.taxa = taxa;
        this.recorrente = recorrente;
        this.cnpj = cnpj;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if(cnpj.length() == 14){
        this.cnpj = cnpj;
        }
    }
    
    
    
}
