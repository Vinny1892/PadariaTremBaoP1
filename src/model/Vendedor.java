package model;

/*
 Vendedores 
devem armazenar o montante de vendas por ele realizados. 
Quando vendedores ultrapassam a meta de vendas estipulada a cada mes,
recebem uma boniﬁcacao de 10% sobre o salario base
 */
public class Vendedor extends GestaoFuncionario {

    private double montanteVenda;
    private int idVendedor;

    public Vendedor(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
    }

    public Vendedor(double montanteVenda, int idVendedor, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
        this.idVendedor = idVendedor;
    }

    //Get Set
    public double getMontanteVenda() {
        return montanteVenda;
    }

    public void setMontanteVenda(double montanteVenda) {
        this.montanteVenda = montanteVenda;
    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

}
