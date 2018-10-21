package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dao.DaoPadeiro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Padeiro;

public class ControllerPadeiro {

    public void salvar(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) throws SQLException {
        try {
            Padeiro padeiro = new Padeiro(nome, endereco, cpf, telefone, salarioBaseMensal, horasEmHorarioAlternativo);
            new DaoPadeiro().salvar(padeiro);
            System.out.println("Metodo salvar ControllerPadeiro realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Padeiro");
        }
    }

    public void editar(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) throws SQLException {
        Padeiro padeiro = new Padeiro(nome, endereco, cpf, telefone, salarioBaseMensal, horasEmHorarioAlternativo);
        new DaoPadeiro().atualizar(padeiro);
        System.out.println("Metodo editar ControllerPadeiro realizado");
    }

    public void deletar(String cpf) throws SQLException {
        new DaoPadeiro().deletar(cpf);
        System.out.println("Metodo deletar ControllerPadeiro realizado");
    }
    
    public Object selecionaObjeto(int id) throws SQLException{
        Padeiro padeiro = (Padeiro) new DaoPadeiro().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerFornecedor realizado");
        return padeiro;
    }
    
    public ArrayList<Padeiro> getAll() throws SQLException {
        ArrayList<Padeiro> padeiros = (ArrayList<Padeiro>) (ArrayList<?>) new DaoPadeiro().getAll();
        return padeiros;
    }
  
    
    
    
    
/*
    public static void main(String[] args) throws SQLException {
        ControllerPadeiro cp = new ControllerPadeiro();
        cp.salvar("luiz", "Rua luizinho", "12345678912", "345678", 4000.00f, 0f);
        //cp.editar("luiz alberto", "rua do luiz alberto", "12345678912", "556755556666", 4500.00f, 10f);
        //cp.deletar("12345678912");
    }*/

}
