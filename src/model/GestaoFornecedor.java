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
public class GestaoFornecedor extends PessoaJuridica {

    private boolean recorrente;
    private int taxaDesconto;
    private int idFornecedor;

    public GestaoFornecedor(boolean recorrente, int taxaDesconto, int idFornecedor, String cnpj, String nome, String endereco) {
        super(cnpj, nome, endereco);
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
        this.idFornecedor = idFornecedor;
    }

    public GestaoFornecedor(boolean recorrente, int taxaDesconto, String cnpj, String nome, String endereco) {
        super(cnpj, nome, endereco);
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
    }

    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado) {
        float valorDesconto = precoCusto * (valorNegociado / 100);
        return valorDesconto;
    }

    //Getters e Setters
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
