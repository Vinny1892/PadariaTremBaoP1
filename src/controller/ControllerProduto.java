package controller;

import dao.DaoFornecedor;
import model.GestaoProduto;
import dao.DaoProduto;
import model.GestaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerProduto {

    public void salvar(String nome, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, fornecedor, precoCusto, apelido, perecivel);
        new DaoProduto().salvar(produto);
        System.out.println("Metodo salvar ControllerProduto realizado");
    }

    public void deletar(String codigo) throws SQLException {
        new DaoProduto().deletar(codigo);
        System.out.println("Metodo deletar ControllerProduto realizado");
    }

    public void editar(String nome, int codigo, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, codigo, fornecedor, precoCusto, apelido, perecivel);
        new DaoProduto().atualizar(produto);
        System.out.println("Metodo editar ControllerProduto realizado");
    }

    public ArrayList<GestaoProduto> getAll() throws SQLException {
        ArrayList< GestaoProduto> produtos = (ArrayList<GestaoProduto>) (ArrayList<?>) new DaoProduto().getAll();
        System.out.println("Metodo getAll ControllerProduto realizado");
        return produtos;
    }

    public Object selecionaObjeto(int id) throws SQLException {
        DaoFornecedor daoFornecedor = null;
        GestaoFornecedor fornecedor = (GestaoFornecedor) daoFornecedor.getById(id);
        System.out.println("Metodo selecionaObejto() ControllerProduto realizado");
        return fornecedor;
    }

}
