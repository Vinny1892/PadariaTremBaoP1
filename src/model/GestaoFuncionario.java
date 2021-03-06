package model;

import javafx.beans.property.SimpleStringProperty;

public abstract class GestaoFuncionario extends PessoaFisica {

    private float salarioBaseMensal;

    public GestaoFuncionario(float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(cpf, telefone, nome, endereco);
        this.salarioBaseMensal = salarioBaseMensal;
    }

    public float getSalarioBaseMensal() {
        return salarioBaseMensal;
    }

    public void setSalarioBaseMensal(float salarioBaseMensal) {
        this.salarioBaseMensal = salarioBaseMensal;
    }

    public SimpleStringProperty profissaoProperty() {
        SimpleStringProperty profissao = null;
        if (this instanceof GestaoGerente) {
            profissao = new SimpleStringProperty("Gerente");
        } else if (this instanceof Padeiro) {
            profissao = new SimpleStringProperty("Padeiro");

        } else if (this instanceof Vendedor) {
            profissao = new SimpleStringProperty("Vendedor");

        }
        return profissao;

    }

}
