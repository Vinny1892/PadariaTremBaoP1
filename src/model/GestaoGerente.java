package model;
/*
Gerentes, por sua vez, tem um aumento no salario base em 20%,
como gratiﬁcaco por funcao de conﬁanca.
*/
public class GestaoGerente extends GestaoFuncionario{

    public GestaoGerente(float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
