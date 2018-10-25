package model;

/*
 Vendedores 
devem armazenar o montante de vendas por ele realizados. 
Quando vendedores ultrapassam a meta de vendas estipulada a cada mes,
recebem uma boniﬁcacao de 10% sobre o salario base
 */
public class Vendedor extends GestaoFuncionario {

    private float montanteVenda;
    private int idVendedor;
    private float metaVenda;

    /*Construtor da classe GestaoFuncionario // Recebe por parametro montante da venda, salario base mensal, cpf, telefone, nome, endereco e meta de venda //
    Utilizado em conjunto com metodos que nao necessitam receber o ID como parametro // Ex: salvar()*/
    public Vendedor(float montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco, float metaVenda) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
        this.metaVenda = metaVenda;
    }

    /*Construtor da classe GestaoFuncionario // Recebe por parametro montante da venda, id do vendedor, salario base mensal, cpf, telefone, nome, endereco e meta de venda //
    Utilizado em conjunto com metodos que necessitam receber o ID como parametro // Ex atulizar(ID), getByID(ID)*/
    public Vendedor(float montanteVenda, int idVendedor, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco, float metaVenda) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
        this.idVendedor = idVendedor;
        this.metaVenda = metaVenda;
    }

    //Getters and Setters
    public float getMontanteVenda() {
        return montanteVenda;
    }

    public void setMontanteVenda(float montanteVenda) {
        this.montanteVenda = montanteVenda;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public float getMetaVenda() {
        return metaVenda;
    }

    public void setMetaVenda(float metaVenda) {
        this.metaVenda = metaVenda;
    }

}
