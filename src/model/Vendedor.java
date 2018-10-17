package model;
/*
 Vendedores 
devem armazenar o montante de vendas por ele realizados. 
Quando vendedores ultrapassam a meta de vendas estipulada a cada mes,
recebem uma boniﬁcacao de 10% sobre o salario base
*/
public class Vendedor extends GestaoFuncionario{
    private double montanteVenda;

    public Vendedor(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.montanteVenda = montanteVenda;
    }
  
    
    
    
    //Getters e Setters
    public double getMontanteVenda() {
        return montanteVenda;
    }

    public void setMontanteVenda(double montanteVenda) {
        this.montanteVenda = montanteVenda;
    }

    public double getMetaVenda() {
        return metaVenda;
    }

    public void setMetaVenda(double metaVenda) {
        this.metaVenda = metaVenda;
    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
