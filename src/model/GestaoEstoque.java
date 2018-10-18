package model;

import java.util.Date;
import model.GestaoProduto;

/*
7. 
Gestao de estoques: a padaria tem de manter estoque de todos os produtos.
As Padarias Trem Bao tem um maximo de 50 tipos diferentes de produtos em suas lojas.
Para cada produto, ha uma capacidade maxima de 30 unidades. 
O sistema deve emitir um alerta quando
as unidades de um determinado produto atingirem o numero mınimo de 1 unidade,
bem como nao permitir a realizacao de vendas que envolvam produtos esgotados em estoque.
O sistema deve, ainda, permitir procurar se um determinado produto encontra-se cadastrado na loja.
 */
public class GestaoEstoque {

    final int maximoTiposProdutos = 50;
    final int maximoPorProduto = 30;
    final int minimoPorProduto = 1;
    private int qtdProduto;
    private String dataValidade;
    private GestaoProduto produto;
    private long idEstoque;

    public GestaoEstoque(int qtdProduto, String dataValidade, GestaoProduto produto) {
        this.qtdProduto = qtdProduto;
        this.dataValidade = dataValidade;
        this.produto = produto;
    }

    public GestaoEstoque(long idEstoque, int qtdProduto, String dataValidade, GestaoProduto produto) {
        this.qtdProduto = qtdProduto;
        this.dataValidade = dataValidade;
        this.produto = produto;
        this.idEstoque = idEstoque;
    }

    public void capacidadeMinima() {

    }

    public boolean venderProduto(GestaoProduto produto) {

        return false;
    }

    public GestaoProduto procurarProduto(GestaoProduto produto) {

        return produto;
    }

    //produto existe?
    public boolean isProduto() {

        return false;
    }

    //get set
    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public GestaoProduto getProduto() {
        return produto;
    }

    public void setProduto(GestaoProduto produto) {
        this.produto = produto;
    }

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}
