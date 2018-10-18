package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.GestaoProduto;
import dao.DaoProduto;
import model.GestaoFornecedor;
import java.util.Date;
import java.text.SimpleDateFormat;
import model.GestaoFornecedor;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerProduto {

    public void salvar(String nome, GestaoFornecedor fornecedor, float precoCusto, String apelido) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, fornecedor, precoCusto, apelido);
        new DaoProduto().salvar(produto);
        System.out.println("Metodo salvar ControllerProduto realizado");
    }

    public void deletar(String codigo) throws SQLException {
        new DaoProduto().deletar(codigo);
    }

    public void editar(String nome, int codigo, GestaoFornecedor fornecedor, float precoCusto, String apelido) throws SQLException {
        GestaoProduto produto = new GestaoProduto(nome, codigo, fornecedor, precoCusto, apelido);
        new DaoProduto().atualizar(produto);
        System.out.println("Metodo editar ControllerProduto realizado");
    }

    public ArrayList<GestaoProduto> getAll() throws SQLException {
        ArrayList< GestaoProduto> produtos = (ArrayList<GestaoProduto>) (ArrayList<?>) new DaoProduto().getAll();
        System.out.println("Metodo getAll realizado");
        return produtos;
    }

    public static void main(String[] args) throws SQLException {
        ControllerProduto cp = new ControllerProduto();
        //GestaoFornecedor fornecedor = new GestaoFornecedor("São Gabriel", "333344445555", "Rua antonio", false, 0);

        //cp.salvar("Leite", fornecedor, 1.00f, "Leite de saquinho");

    }
}
