package controller;

import model.CartaoFidelidade;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.GestaoCliente;
import dao.DaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerCliente {

    public void salvar(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade) throws SQLException {
        GestaoCliente cliente = new GestaoCliente(nome, endereco, cpf, telefone, cartaoFidelidade);
        new DaoCliente().salvar(cliente);
        System.out.println("Metodo salvar ControllerCliente realizado");
    }

    public void editar(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade) throws SQLException {
        GestaoCliente cliente = new GestaoCliente(nome, endereco, cpf, telefone, cartaoFidelidade);
        new DaoCliente().atualizar(cliente);
        System.out.println("Metodo editar ControllerCliente realizado");
    }

    public void deletar(String cpf) throws SQLException {
        new DaoCliente().deletar(cpf);
        System.out.println("Metodo deletar ControllerCliente realizado");
    }
    public Object selecionaObjeto(int id) throws SQLException{
        GestaoCliente cliente = (GestaoCliente) new DaoCliente().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerCartao realizado");
        return cliente;
    }
/*
    public static void main(String[] args) throws SQLException {
        ControllerCliente cc = new ControllerCliente();
        //cc.salvar("Roberto", "Rua Robertina", "67674444333", "99889988");

        //cc.editar("Roberto riba", "Rua Pitanga", "56666666666", "88998899");
        cc.deletar("67674444333");
    }*/
}
