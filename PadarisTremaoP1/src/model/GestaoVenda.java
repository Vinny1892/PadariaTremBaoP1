package model;
/*
6.
Gestao de vendas:
todas as vendas realizadas na loja sao cadastradas com um conjunto de produtos que foram vendidos 
(em um maximo de 20 produtos), 
a data da venda,
o vendedor que realizou a venda e
a forma de pagamento (dinheiro, debito ou credito).
O pagamento das vendas pode ser realizado a vista ou a prazo.
Vendas a prazo tem associado a elas o numero de parcelas, 
bem como um acrescimo de 2% no valor ﬁnal da compra.
*/
import java.util.Date;

public class GestaoVenda {
    Date dataVenda;
    Vendedor vendedor;
    /*
    1 = dinheiro
    2 = debito
    3 = credito
    */
    int formaPagamento;
    //pagamento sem parcelas
    public void cadastrarBDConjuntoProdutosVendido(GestaoProduto carrinho[], Vendedor vendedor,Date dataVenda,int formaPagamento){
        

    }
    // pagamento com parcelas 
    public void cadastrarBDConjuntoProdutosVendido(GestaoProduto carrinho[], Vendedor vendedor,Date dataVenda,int formaPagamento, int nParcelas){
        

    }
    
}
