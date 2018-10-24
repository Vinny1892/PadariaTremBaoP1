package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.GestaoVenda;
import model.GestaoCliente;
import model.Vendedor;
import dao.DaoVenda;
import model.GestaoEstoque;

public class ControllerVenda {
    
    
    public float precoFinalVenda(boolean prazo,float precoFinal){
        if (prazo) {
            precoFinal += precoFinal * 0.02;
        }
        return precoFinal;
    }


    public void salvar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoques, int formaPagamento, float valorTotalVenda) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, estoques, formaPagamento,valorTotalVenda);
        new DaoVenda().salvar(venda);
        System.out.println("Metodo salvar ControllerVenda realizado");
    }

    public void deletar(String idVenda) throws SQLException {
        new DaoVenda().deletar(idVenda);
        System.out.println("Metodo deletar ControllerVenda realizado");
    }

    public void editar(String dataVenda, Vendedor vendedor, GestaoCliente cliente, ArrayList<GestaoEstoque> estoque, int formaPagamento, float valorTotalVenda) throws SQLException {
        GestaoVenda venda = new GestaoVenda(dataVenda, vendedor, cliente, estoque, formaPagamento, valorTotalVenda);
        new DaoVenda().atualizar(venda);
        System.out.println("Metodo editar ControllerVenda realizado");
    }

    public ArrayList<GestaoVenda> getAll() throws SQLException {
        ArrayList< GestaoVenda> vendas = (ArrayList<GestaoVenda>) (ArrayList<?>) new DaoVenda().getAll();
        System.out.println("Metodo getAll() ControllerVenda realizado");
        return vendas;
    }
        /*
    Metodo utilizado para chamar o metodo getById() da classes DaoVenda,
    retornando um ArrayList de objetos GestaoVenda, pois o id_venda pode se repetir.
     */
    public ArrayList<GestaoVenda> selecionaObjetosById(int id) throws SQLException {
        ArrayList<GestaoVenda> vendasById = (ArrayList<GestaoVenda>) (ArrayList<?>) new DaoVenda().getById(id);
        System.out.println("Metodo selecionaObjetosById ControllerVenda realizado");
        return vendasById;
    }




}
