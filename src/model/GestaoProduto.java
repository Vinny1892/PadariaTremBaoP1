/*
2. 
Gestao de produtos: 
todos os produtos tem um 
nome,
um codigo (numerico de 6 dıgitos),
um fornecedor,
um preco de custo
e um preco ﬁnal.
Os produtos podem ser divididos em perecıveis e nao perecıveis.
Aqueles perecıveis, deve-se controlar a data de validade.
Ainda, alguns produtos podem ter um apelido,
que pode variar de acordo com a regiao do paıs em que se encontra a unidade da franquia.
 */
package model;

import javafx.beans.property.SimpleFloatProperty;

public class GestaoProduto {

    private String nome;
    private int idproduto;
    private GestaoFornecedor fornecedor;
    private float precoCusto;
    private boolean perecivel;
    private String apelido;

    public GestaoProduto(String nome, int idproduto, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) {
        this.nome = nome;
        this.idproduto = idproduto;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.apelido = apelido;
        this.perecivel = perecivel;
    }

    public GestaoProduto(String nome, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.apelido = apelido;
        this.perecivel = perecivel;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GestaoFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(GestaoFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    @Override
    public String toString() {
        return nome;
    }

}
