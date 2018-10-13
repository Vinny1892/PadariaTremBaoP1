package model;
/*
3. Gestao de funcionarios:
todos os funcionarios tem um 
nome, 
endereco,
CPF,
telefone e
um salario base mensal.
Uma unidade da padaria pode ter funcionarios do tipo 
vendedor, gerente e padeiro.
Vendedores devem armazenar o montante de vendas por ele realizados.Quando vendedores ultrapassam a meta de vendas estipulada a cada mes, recebem uma boniﬁca¸ca˜o de 10% sobre o sala´rio base. 
Gerentes, por sua vez, tˆem um aumento no sala´rio base em 20%, como gratiﬁcac¸˜ao por func¸˜ao de conﬁanc¸a.
Padeiros, por ﬁm, tˆem uma jornada de trabalho em hora´rio alternativo, cumprindo algumas horas em hora´rios noturnos (madrugada). Padeiros devem receber uma gratiﬁca¸ca˜o de 25% sobre o sal´ario base, como adicional noturno, para cada hora trabalhada em hora´rio alternativo.

*/
public abstract class GestaoFuncionario extends Pessoa {
    String nome;
    String endereco;
    String cpf;
    int telefone;
    float salarioBaseMensal;
    
    // sera usado nas clases vendedor, gerente e padeiro
    public abstract float gratificacao();
}

