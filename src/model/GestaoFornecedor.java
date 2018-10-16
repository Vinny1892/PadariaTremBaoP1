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
    private long id;
    private String cnpj;
    private boolean recorrente;
    private int taxaDesconto;

    public GestaoFornecedor(String nome, String cnpj, String endereco, boolean recorrente,int taxaDesconto) {
        super(nome,endereco);
        if(cnpj.length() == 14){
            this.cnpj = cnpj;
        }else{
            System.out.println("CNPJ menor que 14 digitos");
        }
        this.recorrente = recorrente;
        this.taxaDesconto = taxaDesconto;
    }

       public GestaoFornecedor(long id ,String nome, String cnpj, String endereco, boolean recorrente,int taxaDesconto) {    
           super(nome, endereco);
           this.id = id;
           if (cnpj.length() == 14) {
               this.cnpj = cnpj;
           }else{
               System.out.println("CNPJ diferente de 14 digitos");
           }
           this.recorrente = recorrente;
           this.taxaDesconto = taxaDesconto;
    }
    
    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado){
        float valorDesconto = precoCusto * (valorNegociado/100);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
}

}