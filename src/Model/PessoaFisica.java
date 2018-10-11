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
public abstract class PessoaFisica extends Pessoa{
    private String cpf;
    private String telefone;

    public PessoaFisica(String cpf, String telefone, String nome, String endereco) {
        super(nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }

  

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf.length() == 11){
        this.cpf = cpf;
            }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.length() == 9){
        this.telefone = telefone;
            }
    }
    
    
    
}
