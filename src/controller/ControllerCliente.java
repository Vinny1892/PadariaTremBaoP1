package controller;

import model.CartaoFidelidade;
import model.GestaoCliente;
import dao.DaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerCliente {

    /*
    Metodo utilizado para calcular o desconto do cliente
    recebendo o cliente que comrprou e o valor da compra
    retornando o desconto;
     */
    public float descontoCliente(GestaoCliente cliente, float valorTotalCompra) {
        float desconto = 0;
        if (cliente.getCartaoFidelidade().isGold()) {
            return desconto = valorTotalCompra * 0.05f;
        } else if (cliente.getCartaoFidelidade().isPlatinum()) {
            return desconto = valorTotalCompra * 0.10f;
        }
        return desconto;
    }

    /*
    Metodo utilizado chamar o metodo salvar() da classe DaoCliente,
    passando como parametro objeto GestaoCliente a ser salva.
     */
    public void salvar(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade) throws SQLException {
        GestaoCliente cliente = new GestaoCliente(nome, endereco, cpf, telefone, cartaoFidelidade);
        new DaoCliente().salvar(cliente);
        System.out.println("Metodo salvar ControllerCliente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atualizar() da classe DaoCliente
    passando como parametro o objeto GestaoCliente a ser editado e como ser editado.
     */
    public void editar(String nome, String endereco, String cpf, String telefone, CartaoFidelidade cartaoFidelidade) throws SQLException {
        GestaoCliente cliente = new GestaoCliente(nome, endereco, cpf, telefone, cartaoFidelidade);
        new DaoCliente().atualizar(cliente);
        System.out.println("Metodo editar ControllerCliente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classeDaoCliente
    passando como o parametro o cpf. 
     */
    public void deletar(String cpf) throws SQLException {
        new DaoCliente().deletar(cpf);
        System.out.println("Metodo deletar ControllerCliente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getById()  da classe DaoCliente,
    passando como parametro o id do cliente a ser pego,
    e retornando o objeto cliente.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        GestaoCliente cliente = (GestaoCliente) new DaoCliente().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerCliente realizado");
        return cliente;
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoCliente,
    retornando um ArrayList de objetos do tipo GestaoCliente.
     */
    public ArrayList<GestaoCliente> getAll() throws SQLException {
        ArrayList<GestaoCliente> produtos = (ArrayList<GestaoCliente>) (ArrayList<?>) new DaoCliente().getAll();
        System.out.println("Metodo getAll ControllerCliente realizado");
        return produtos;
    }
    /*
    public static void main(String[] args) throws SQLException {
        ControllerCliente cc = new ControllerCliente();
        //cc.salvar("Roberto", "Rua Robertina", "67674444333", "99889988");

        //cc.editar("Roberto riba", "Rua Pitanga", "56666666666", "88998899");
        cc.deletar("67674444333");
    }*/
}
