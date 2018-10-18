package controller;

import model.GestaoEstoque;
import dao.DaoEstoque;
import java.sql.SQLException;
import java.util.Date;
import model.GestaoProduto;

public class ControllerEstoque {
    public void salvar(String nome, String cpf, String endereco, String telefone,float salarioBaseMensal, int porcentagemGratificacao) throws SQLException{
        GestaoEstoque estoque = new GestaoEstoque(nome, cpf, endereco, telefone, salarioBaseMensal, porcentagemGratificacao);
        new DaoEstoque().salvar(estoque);
        System.out.println("Metodo salvar ControllerGerente realizado");
    }
    
    public void deletar(String nome) throws SQLExceptionion{
     new DaoEstoque().deletar(nome);
        System.out.println("Metodo deletar ControllerGerente realizado");
    }
    
    public void editar(int qtdProduto, Date dataValidade, GestaoProduto produto) throws SQLException{
      GestaoEstoque estoque = new GestaoEstoque(qtdProduto, dataValidade, produto);
      new DaoEstoque().atualizar(estoque);
      System.out.println("Metodo editar ControllerGerente realizado");
    }
    
    public static void main(String[] args)throws SQLException {
        ControllerGerente cg = new ControllerGerente();
        //cg.salvar("nomeGerente", "22222233333", "rua gerente", "556732323232", 3000.00f, 10);
        //cg.editar("eduardogomes", "22222233333", "rua gerente1", "556700323232", 3000.00f, 5);
        //cg.deletar("11111111111");
    }
}
