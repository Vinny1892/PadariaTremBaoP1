/*
9.
Gestao das informacoes: 
o sistema deve permitir que imprima-se um relatorio sobre os 
funcionarios,
os clientes,
os produtos ou 
os fornecedores existentes.
Os relatorios podem ser 
individuais, exibindo as informacoes de um exemplo de uma entidade (funcionario / cliente / produto / fornecedor) especiﬁcado pelo usu´ario,
ou sobre o conjunto de todos os exemplos daquela entidade. 
Por exemplo, 
se o usuario procurar pelo funcionario de codigo 1234,
devese exibir todas as informa¸co˜es deste funcionario.
Entretanto, se o usuario optar por nAo especiﬁcar o usuario, 
deve-se exibir todas as informacoes de todos os funcionarios.
 */
package model;

public class GestaoInformacao {

    //Cliente especifico
    public GestaoCliente relatorioClientes(int codigoCliente) {
        GestaoCliente cliente = null;
        return cliente;
    }

    //todos os clientes
    public GestaoCliente relatorioClientes() {
        GestaoCliente clientes = null;
        return clientes;
    }

    //funcionario especifico
    public GestaoFuncionario relatorioFuncionarios(int codigoFuncionario) {
        GestaoFuncionario funcionario = null;
        return funcionario;
    }

    //todos os funcionarios
    public GestaoFuncionario relatorioFuncionarios() {
        GestaoFuncionario funcionarios = null;
        return funcionarios;
    }

    //produtos especifico
    public GestaoProduto relatorioProdutos(int codigoProduto) {
        GestaoProduto produto = null;
        return produto;
    }

    //todos os produtos
    public GestaoProduto relatorioProdutos() {
        GestaoProduto produtos = null;
        return produtos;
    }

    //fornecedor especifico
    public GestaoFornecedor relatorioFornecedor(int codigoFornecedor) {
        GestaoFornecedor fornecedor = null;
        return fornecedor;
    }

    //todos os fornecedores
    public GestaoFornecedor relatorioFornecedor() {
        GestaoFornecedor fornecedores = null;
        return fornecedores;
    }

}
