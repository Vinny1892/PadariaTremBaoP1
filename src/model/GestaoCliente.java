package model;

import model.CartaoFidelidade;

/*
Gestao de clientes:
todos os clientes devem estar cadastrados na loja, para ﬁns de publicidade direcionada.
Assim, todos os clientes sao caracterizados por seu nome, endereco, telefone e CPF.

 */
public class GestaoCliente {

    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    private CartaoFidelidade cartaoFidelidade;
    private int idCliente;

    /*Construtor da classe GestaoCliente // Recebe por parametro nome, endereco, cpf, telefone, cartao fidelidade e id do cliente //
    Utilizado em conjunto com metodos que necessitam receber o ID por parametro // Exemplo: getById(ID), getAll(), atualizar(Object)*/

    public GestaoCliente(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade, int idCliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cartaoFidelidade = cartaoFidelidade;
        this.idCliente = idCliente;
    }

    /*Construtor da classe GestaoCliente // Recebe por parametro nome, endereco, cpf, telefone e cartaoFidelidade //
    Utilizado em conjunto com metodos que nao necessitam receber o ID por parametro // Exemplo: salvar(Object)*/

    public GestaoCliente(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cartaoFidelidade = cartaoFidelidade;
    }

    // Getters e Setters

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

    public String getCpf() {
        return cpf;
    }

    /*
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
     */
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CartaoFidelidade getCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(CartaoFidelidade cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
