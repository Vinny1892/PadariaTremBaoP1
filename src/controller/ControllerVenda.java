package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.GestaoVenda;
import model.GestaoCliente;
import model.Vendedor;
import dao.DaoVenda;
import model.GestaoEstoque;

public class ControllerVenda {

    public void salvar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoques, int formaPagamento) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, estoques, formaPagamento);
        new DaoVenda().salvar(venda);
        System.out.println("Metodo salvar ControllerVenda realizado");
    }

    public void deletar(String idVenda) throws SQLException {
        new DaoVenda().deletar(idVenda);
        System.out.println("Metodo deletar ControllerVenda realizado");
    }

    public void editar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoque, int formaPagamento) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, estoque, formaPagamento);
        new DaoVenda().atualizar(venda);
        System.out.println("Metodo editar ControllerVenda realizado");
    }

    public ArrayList<GestaoVenda> getAll() throws SQLException {
        ArrayList< GestaoVenda> produtos = (ArrayList<GestaoVenda>) (ArrayList<?>) new DaoVenda().getAll();
        System.out.println("Metodo getAll realizado");
        return produtos;
    }

}
