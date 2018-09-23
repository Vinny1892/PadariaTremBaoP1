package model;
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

    
    
    public void capacidadeMinima(){
    
    
    
    }
    public boolean venderProduto(GestaoProduto produto){
    
        return false;
    }
    public GestaoProduto procurarProduto(GestaoProduto produto){
    
        return produto;
    }
    
    //produto existe?
    public boolean isProduto(){
    
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //get set
    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}
