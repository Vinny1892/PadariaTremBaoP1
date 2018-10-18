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

import java.text.Format;
import java.util.Date;

public class GestaoProduto {

    private String nome;
    private int codigo;
    private GestaoFornecedor fornecedor;
    private float precoCusto;
    //private float precoFinal;
    //private boolean perecivel;
    //private Format dataValidade;
    private String apelido;
    private int idfornecedor;

    public GestaoProduto(String nome, int codigo, GestaoFornecedor fornecedor, float precoCusto, String apelido, int idfornecedor) {
        this.nome = nome;
        this.codigo = codigo;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.apelido = apelido;
        this.idfornecedor = idfornecedor;
    }

    public GestaoProduto(String nome, GestaoFornecedor fornecedor, float precoCusto, String apelido, int idfornecedor) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.apelido = apelido;
        this.idfornecedor = idfornecedor;
    }
    

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

}
