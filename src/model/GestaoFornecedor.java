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
public class GestaoFornecedor extends Pessoa {

    private String cnpj;
    private boolean recorrente;
    private int taxaDesconto;
    private int idFornecedor;

    public GestaoFornecedor(String cnpj, boolean recorrente, String nome, String endereco) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.recorrente = recorrente;
    }


    
    

    public GestaoFornecedor(int idFornecedor, String nome, int taxaDesconto, String endereco, boolean recorrente, String cnpj) {
        super(nome, endereco);
        if (cnpj.length() == 14) {
            this.cnpj = cnpj;
        } else {
            System.out.println("CNPJ menor que 14 digitos");
        }
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
        this.idFornecedor = idFornecedor;
    }

    public GestaoFornecedor(int idfornecedor, String nome, String cnpj, String endereco, boolean recorrente, int taxaDesconto) {
        super(nome, endereco);
        if (cnpj.length() == 14) {
            this.cnpj = cnpj;
        } else {
            System.out.println("CNPJ diferente de 14 digitos");
        }
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
        this.idFornecedor = idfornecedor;
    }

  

    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado) {
        float valorDesconto = precoCusto * (valorNegociado / 100);
        return valorDesconto;
    }

    //Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    public int getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(int taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public int getIdfornecedor() {
        return idFornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idFornecedor = idfornecedor;
    }

}
