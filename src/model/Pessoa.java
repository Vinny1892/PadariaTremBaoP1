package model;

public abstract class Pessoa {

    private String nome;
    private String endereco;

    /*Construtor da classe abstrata Pessoa // Recebe por parametro o nome e endereco*/

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    //Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
