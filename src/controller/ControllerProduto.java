package controller;

import model.GestaoProduto;
import dao.DaoProduto;
import model.GestaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerProduto {

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoProduto,
    passando como parametro o objeto GestaoProduto a ser salvo.
     */
    public void salvar(String nome, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, fornecedor, precoCusto, apelido, perecivel);
        new DaoProduto().salvar(produto);
        System.out.println("Metodo salvar ControllerProduto realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoProduto,
    passando como parametro o idProduto, para saber qual produto sera deletado.
     */
    public void deletar(String codigo) throws SQLException {
        new DaoProduto().deletar(codigo);
        System.out.println("Metodo deletar ControllerProduto realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atualizar() da classe DaoProduto,
    passando como parametro o objeto GestaoProduto a ser editado,
    de acordo com idProduto deste objeto.
     */
    public void editar(String nome, int codigo, GestaoFornecedor fornecedor, float precoCusto, String apelido, boolean perecivel) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, codigo, fornecedor, precoCusto, apelido, perecivel);
        new DaoProduto().atualizar(produto);
        System.out.println("Metodo editar ControllerProduto realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoProduto,
    retornando um ArrayList de objetos do tipo GestaoProduto.
     */
    public ArrayList<GestaoProduto> getAll() throws SQLException {
        ArrayList< GestaoProduto> produtos = (ArrayList<GestaoProduto>) (ArrayList<?>) new DaoProduto().getAll();
        System.out.println("Metodo getAll ControllerProduto realizado");
        return produtos;
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoProduto,
    passando como parametro o idProduto a pegar,
    retornando o objeto GestaoProduto encontrado.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        GestaoProduto produto = (GestaoProduto) new DaoProduto().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerProduto realizado");
        return produto;
    }

}
