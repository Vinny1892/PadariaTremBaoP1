package controller;

import dao.DaoPadeiro;
import java.sql.SQLException;
import model.Padeiro;


public class ControllerPadeiro {
    
    public void salvar(float horasEmHorarioAlternativo, String nome, String cpf, String endereco, String telefone,float salarioBaseMensal) throws SQLException{
        Padeiro padeiro = new Padeiro(horasEmHorarioAlternativo,salarioBaseMensal, cpf,telefone,nome, endereco);
        new DaoPadeiro().salvar(padeiro);
        System.out.println("Metodo salvar ControllerPadeiro realizado");
    }
    
    
    public void editar(long id, String nome, String endereco, String cpf,String telefone,float salarioBaseMensal,   float horasEmHorarioAlternativo) throws SQLException{
      Padeiro padeiro = new Padeiro(id, nome, endereco, cpf, telefone, salarioBaseMensal, horasEmHorarioAlternativo);
      new DaoPadeiro().atualizar(padeiro);
      System.out.println("Metodo editar ControllerPadeiro realizado");
    }
    
    public void deletar(String nome) throws SQLException{
     new DaoPadeiro().deletar(nome);
        System.out.println("Metodo deletar ControllerPadeiro realizado");
    }
    
    public static void main(String[] args) throws SQLException{
        ControllerPadeiro cp = new ControllerPadeiro();
        //cp.salvar(0f, "luiz", "22222222222", "rua do luiz", "675555555555", 4000.00f);
        //cp.editar(1, "luiz alberto", "rua do luiz alberto", "22222222222", "556755556666", 4500.00f, 10);
        //cp.deletar(1);
    }
    
}
