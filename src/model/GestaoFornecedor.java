package model;
/*
1. 
Gestao de fornecedores: 
a padaria recebe produtos de diversos fornecedores.
Cada fornecedor é caracterizado por um 
nome,
um endereco 
e um CNPJ.
Os fornecedores podem ser recorrentes ou ocasionais.
Fornecedores recorrentes tem associados a eles uma taxa negociada de descontos,
aplicavel no preco de custo de todos os produtos por eles fornecidos.

*/
public class GestaoFornecedor {
    private String nome;
    private String cnpj;
    private String endereco;
    private boolean recorrente;
    
    
    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado){
        float valorDesconto = precoCusto * valorNegociado;
        return valorDesconto;
    }

    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }
}
