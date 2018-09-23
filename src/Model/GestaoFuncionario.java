package Model;

public abstract class GestaoFuncionario {
    String nome;
    String endereco;
    String cpf;
    int telefone;
    float salarioBaseMensal;
    
    // sera usado nas clases vendedor, gerente e padeiro
    public abstract int gratificacao();
}

