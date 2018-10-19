package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoVenda;
import model.GestaoCliente;
import model.Vendedor;
import dao.DaoVenda;


public class ControllerVenda {
    public void salvar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, int formaPagamento) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, formaPagamento);
        new DaoVenda().salvar(venda);
        System.out.println("Metodo salvar ControllerVenda realizado");
    }

    public void deletar(String codigo) throws SQLException {
        new DaoVenda().deletar(codigo);
        System.out.println("Metodo deletar ControllerVenda realizado");
    }

    public void editar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, int formaPagamento, int idVendas) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, formaPagamento, idVendas);
        new DaoVenda().atualizar(venda);
        System.out.println("Metodo editar ControllerVenda realizado");
    }

    public ArrayList<GestaoVenda> getAll() throws SQLException {
        ArrayList< GestaoVenda> produtos = (ArrayList<GestaoVenda>) (ArrayList<?>) new DaoVenda().getAll();
        System.out.println("Metodo getAll realizado");
        return produtos;
    }

}
