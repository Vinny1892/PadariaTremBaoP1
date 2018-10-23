package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dao.DaoCartaoFidelidade;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CartaoFidelidade;
import model.GestaoCliente;

/*

 Gestão de um cartao fidelidade: de acordo com o valor acumulado em compras, os clientes
podem tornar-se Clientes Gold ou Clientes Platinum. Clientes Gold tem 5% de desconto em
suas compras. Clientes Platinum tem 10% de desconto em suas compras.

 */
public class ControllerCartao {

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoCartaoFidelidade,
    passando como parametro o objeto CartaoFidelidade a ser salvo.
     */
    public void salvar(boolean gold, boolean platinum, GestaoCliente cliente) throws SQLException {
        CartaoFidelidade cartao = new CartaoFidelidade(gold, platinum);
        new DaoCartaoFidelidade().salvar(cartao);
        System.out.println("Metodo salvar ControllerCartao realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atuzalizar() da classe DaoCartaoFidelidade,
    passando como parametro o objeto CartaoFidelidade a ser editado,
    de acordo com idCartao deste objeto.
    */
    public void editar(int idcartaoFidelidade, boolean gold, boolean platinum, GestaoCliente cliente) throws SQLException {
        CartaoFidelidade cartao = new CartaoFidelidade(idcartaoFidelidade, gold, platinum/*, cliente*/);
        new DaoCartaoFidelidade().atualizar(cartao);
        System.out.println("Metodo editar ControllerCartao realizado");
    }
    
    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoCartaoFidelidade,
    passando como parametro o idCartao, para saber qual cartao sera deletado.
    */
    public void deletar(String idCartao) throws SQLException {
        new DaoCartaoFidelidade().deletar(idCartao);
        System.out.println("Metodo deletar ControllerCartao realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoCartaoFidelidade,
    passando como parametro o idCartao a pegar,
    retornando o objeto CartaoFidelidade encontrado.
    */
    public Object selecionaObjeto(int id) throws SQLException {
        CartaoFidelidade cartao = (CartaoFidelidade) new DaoCartaoFidelidade().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerCartao realizado");
        return cartao;
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoCartaoFidelidade,
    retornando um ArrayList de objetos do tipo CartaoFidelidade.
    */
    public ArrayList<CartaoFidelidade> getAll() throws SQLException {
        ArrayList<CartaoFidelidade> cartoes = (ArrayList<CartaoFidelidade>) (ArrayList<?>) new DaoCartaoFidelidade().getAll();
        System.out.println("Metodo getAll ControllerCartao realizado");
        return cartoes;
    }
}
