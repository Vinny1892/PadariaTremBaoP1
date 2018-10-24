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
import java.util.ArrayList;
import java.util.Date;

public class GestaoVenda {

    private String dataVenda;
    private Vendedor vendedor;
    private GestaoCliente cliente;
    private ArrayList<GestaoEstoque> estoques;
    /*
    1 = dinheiro
    2 = debito
    3 = credito
     */
    private int formaPagamento;
    private int idVenda;
    private int numeroParcelas;
    private float valorTotalVenda;

    /*Construtor da classe GestaoVenda // Recebe por parametro data da venda, vendedor, cliente, estoque, forma de pagamento, id da venda, qntde de parcelas e valor total da venda //
    Utilzado para realizar o gerenciamento de vendas parceladas*/

    public GestaoVenda(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoques, int formaPagamento, int idVenda, int numeroParcelas, float valorTotalVenda) {
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.estoques = estoques;
        this.formaPagamento = formaPagamento;
        this.idVenda = idVenda;
        this.numeroParcelas = numeroParcelas;
        this.valorTotalVenda = valorTotalVenda;
    }

    /*Construtor da classe GestaoVenda // Recebe por parametro data da venda, vendedor, cliente, estoque, forma de pagamento, id da venda e valor total da venda //
    Utilzado para realizar o gerenciamento de vendas a vista*/
    // com id_vendas sem numero de parcelas
    public GestaoVenda(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoques, int formaPagamento, int idVenda, float valorTotalVenda) {
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.idVenda = idVenda;
        this.estoques = estoques;
        this.valorTotalVenda = valorTotalVenda;
    }

    //sem id e sem n parcelas
    public GestaoVenda(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoques, int formaPagamento, float valorTotalVenda) {
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.estoques = estoques;
        this.formaPagamento = formaPagamento;
        this.valorTotalVenda = valorTotalVenda;
    }

    // colocar no controller esses metodos?
    //pagamento sem parcelas
    public void cadastrarBDConjuntoProdutosVendido(GestaoProduto carrinho[], Vendedor vendedor, Date dataVenda, int formaPagamento) {

    }

    // pagamento com parcelas 
    public void cadastrarBDConjuntoProdutosVendido(GestaoProduto carrinho[], Vendedor vendedor, Date dataVenda, int formaPagamento, int nParcelas) {

    }

    //Getters and Setters

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public GestaoCliente getCliente() {
        return cliente;
    }

    public void setCliente(GestaoCliente cliente) {
        this.cliente = cliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public ArrayList<GestaoEstoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(ArrayList<GestaoEstoque> estoques) {
        this.estoques = estoques;
    }

    public float getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(float valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

}
