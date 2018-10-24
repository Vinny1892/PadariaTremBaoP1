package model;

import java.util.Date;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
    private int idEstoque;

    public GestaoEstoque(int qtdProduto, String dataValidade, GestaoProduto produto) {
        this.qtdProduto = qtdProduto;
        this.dataValidade = dataValidade;
        this.produto = produto;
    }

    public GestaoEstoque(int idEstoque, int qtdProduto, String dataValidade, GestaoProduto produto) {
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

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public SimpleStringProperty produtoNomeProperty() {
        SimpleStringProperty nome = new SimpleStringProperty(produto.getNome());
        return nome;
    }

    public SimpleStringProperty produtoCodigoProperty() {
        String codigoMostrar = String.valueOf(produto.getIdproduto());
        switch (codigoMostrar.length()) {
            case 1:
                codigoMostrar = "00000" + codigoMostrar;
                break;
            case 2:
                codigoMostrar = "0000" + codigoMostrar;
                break;
            case 3:
                codigoMostrar = "000" + codigoMostrar;
                break;
            case 4:
                codigoMostrar = "00" + codigoMostrar;
                break;
            case 5:
                codigoMostrar = "0" + codigoMostrar;
                break;
            default:
                System.out.println("Implementar Erro codigo Maior que 6 digitos");
                break;
        }
        SimpleStringProperty codigo = new SimpleStringProperty(codigoMostrar);
        return codigo;
    }

    public SimpleFloatProperty precoCustoProperty() {
        return new SimpleFloatProperty(produto.getPrecoCusto());
    }

}
