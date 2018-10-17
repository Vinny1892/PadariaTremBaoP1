package model;

public abstract class GestaoFuncionario extends PessoaFisica{
    private float salarioBaseMensal;

    public GestaoFuncionario(float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(cpf, telefone, nome, endereco);
        
        this.salarioBaseMensal = salarioBaseMensal;
    }

    // sera usado nas clases vendedor, gerente e padeiro
    public abstract int gratificacao();

    public float getSalarioBaseMensal() {
        return salarioBaseMensal;
    }

    public void setSalarioBaseMensal(float salarioBaseMensal) {
        this.salarioBaseMensal = salarioBaseMensal;
    }
    
    public float mostraSalarioFinal(){
        float salarioFinal = gratificacao() + getSalarioBaseMensal();
        return salarioFinal;
    }
    
}

