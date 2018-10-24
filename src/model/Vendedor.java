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

    public Vendedor(float montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco, float metaVenda) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
        this.metaVenda = metaVenda;
    }

    public Vendedor(float montanteVenda, int idVendedor, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco, float metaVenda) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
        this.idVendedor = idVendedor;
        this.metaVenda = metaVenda;
    }

    //Get Set
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
