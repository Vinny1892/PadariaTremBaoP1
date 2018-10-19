package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dao.DaoCartaoFidelidade;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CartaoFidelidade;
import model.GestaoCliente;

public class ControllerCartao {
    public void salvar(boolean gold, boolean platinum, GestaoCliente cliente) throws SQLException{
        try{
            CartaoFidelidade cartao = new CartaoFidelidade(gold, platinum, cliente);
            new DaoCartaoFidelidade().salvar(cartao);
            System.out.println("Metodo salvar ControllerCartao realizado");
        }catch(MySQLIntegrityConstraintViolationException e){
            System.out.println("Cliente Ja possui cartao");
            JOptionPane.showMessageDialog(null, "Cliente ja possui cartao");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cartao");
        } 
    }
    
    public void editar(int idcartaoFidelidade, boolean gold, boolean platinum, GestaoCliente cliente) throws SQLException{
        CartaoFidelidade cartao = new CartaoFidelidade(idcartaoFidelidade,gold, platinum, cliente);
        new DaoCartaoFidelidade().atualizar(cartao);
        System.out.println("Metodo editar ControllerCartao realizado");
    }
    
    public void deletar(String idCartao) throws SQLException{
        new DaoCartaoFidelidade().deletar(idCartao);
        System.out.println("Metodo deletar ControllerCartao realizado");
    }
    
    public Object selecionaObjeto(int id) throws SQLException{
        CartaoFidelidade cartao = (CartaoFidelidade) new DaoCartaoFidelidade().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerCartao realizado");
        return cartao;
    }
    
    public ArrayList <CartaoFidelidade> getAll() throws SQLException {
        ArrayList <CartaoFidelidade> cartoes = (ArrayList<CartaoFidelidade>) (ArrayList<?>) new DaoCartaoFidelidade().getAll();
        System.out.println("Metodo getAll ControllerCartao realizado");
        return cartoes;
    }
}
