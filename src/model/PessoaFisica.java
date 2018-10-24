package model;

public abstract class PessoaFisica extends Pessoa {

    private String cpf;
    private String telefone;

    /*Construtor da classe abstrata PessoaFisica // Recebe por parametro o cpf, telefone, nome e endereco */

    public PessoaFisica(String cpf, String telefone, String nome, String endereco) {
        super(nome, endereco);
        setCpf(cpf);
        this.telefone = telefone;
    }

    //Getters and Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF deve possuir 11 digitos");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone.length() == 9) {
            this.telefone = telefone;
        }
    }

}
