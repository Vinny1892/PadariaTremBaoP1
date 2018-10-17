package controller;

import model.GestaoGerente;
import dao.DaoGerente;
import java.sql.SQLException;

public class ControllerGerente {
    
    public void salvar(String nome, String cpf, String endereco, String telefone,float salarioBaseMensal, int porcentagemGratificacao) throws SQLException{
      GestaoGerente gerente = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal, porcentagemGratificacao);
      new DaoGerente().salvar(gerente);
        System.out.println("Metodo salvar ControllerGerente realizado");
    }
    
    public void deletar(String nome) throws SQLException{
     new DaoGerente().deletar(nome);
        System.out.println("Metodo deletar ControllerGerente realizado");
    }
    
    public void editar(String nome, String cpf, String endereco, String telefone,float salarioBaseMensal, int porcentagemGratificacao) throws SQLException{
      GestaoGerente fornecedor = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal, porcentagemGratificacao);
      new DaoGerente().atualizar(fornecedor);
      System.out.println("Metodo editar ControllerGerente realizado");
    }
    
    public static void main(String[] args)throws SQLException {
        ControllerGerente cg = new ControllerGerente();
        //cg.salvar("nomeGerente", "11111111111", "rua gerente", "556732323232", 3000.00f, 10);
        //cg.editar("nome Gente Editado", "21111111111", "rua gerente1", "556700323232", 3000.00f, 5);
        //cg.deletar(1);
    }
    
}
