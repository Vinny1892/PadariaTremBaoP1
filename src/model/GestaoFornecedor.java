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
    private long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private boolean recorrente;
    private int taxaDesconto;

    public GestaoFornecedor(String nome, String cnpj, String endereco, boolean recorrente,int taxaDesconto) {
        this.nome = nome;
        if(cnpj.length() == 14){
        this.cnpj = cnpj;
        }
        this.endereco = endereco;
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
    }
    
    
       public GestaoFornecedor(long id ,String nome, String cnpj, String endereco, boolean recorrente,int taxaDesconto) {
        this.id = id;
        this.nome = nome;
        if(cnpj.length() == 14){
        this.cnpj = cnpj;
        }
        this.endereco = endereco;
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
    }
    
    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado){
        float valorDesconto = precoCusto * (valorNegociado/100);
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

    public float getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(int taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
