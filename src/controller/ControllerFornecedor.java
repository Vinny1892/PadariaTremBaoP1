package controller;

import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoEstoque;
import model.GestaoFornecedor;

public class ControllerFornecedor {

    public float descontoFornecedor(GestaoFornecedor fornecedor, float precoProduto) {
        float descontoForncedor = 0f;
        if (fornecedor.isRecorrente()) {
            descontoForncedor = fornecedor.getTaxaDesconto() * precoProduto;
        }
        return descontoForncedor;
    }


    /*
    Metodo utilizado para chamar o metodo salvar() da classe DaoFornecedor,
    passando como parametro o objeto GestaoFornecedor.
     */
    public void salvar(String cnpj, boolean recorrente, String nome, String endereco, String taxa) throws SQLException {
        if (recorrente) {
            GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, recorrente, Integer.parseInt(taxa));
            new DaoFornecedor().salvar(fornecedor);
        } else {
            GestaoFornecedor fornecedor = new GestaoFornecedor(recorrente, cnpj, nome, endereco);
            new DaoFornecedor().salvar(fornecedor);
        }
//        System.out.println("Metodo salvar ControllerFonecedor realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoFornecedor,
    passando o cnpj ou id do fornecedor a ser deletado.
     */
    public void deletar(String cnpj) throws SQLException {
        new DaoFornecedor().deletar(cnpj);
        System.out.println("Metodo deletar ControllerFonecedor realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atualizar() da classe DaoFornecedor,
    de acordo com id, passando como parametro o objeto GestaoFornecedor.
     */
    public void editar(int idFornecedor, String nome, String cnpj, String endereco, boolean recorrente, String taxaDesconto) throws SQLException {
        if (recorrente) {
            GestaoFornecedor fornecedor = new GestaoFornecedor(idFornecedor, nome, cnpj, endereco, recorrente, Integer.parseInt(taxaDesconto));
            new DaoFornecedor().atualizar(fornecedor);
        } else {
            GestaoFornecedor fornecedor = new GestaoFornecedor(idFornecedor, nome, cnpj, endereco);
            new DaoFornecedor().atualizar(fornecedor);
        }
        System.out.println("Metodo editar ControllerFornecedor realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoFornecedor,
    retornando um ArrayList de objeto GestaoFornecedor.
     */
    public ArrayList<GestaoFornecedor> getAll() throws SQLException {
        ArrayList<GestaoFornecedor> fornecedores = (ArrayList<GestaoFornecedor>) (ArrayList<?>) new DaoFornecedor().getAll();
        return fornecedores;
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoFornecedor,
    de acordo com id recebido,
    retornando objeto encotrado.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        GestaoFornecedor fornecedor = (GestaoFornecedor) new DaoFornecedor().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerFornecedor realizado");
        return fornecedor;
    }

}
